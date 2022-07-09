package polygon.services;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.*;
import polygon.repos.BuildingRepository;
import polygon.repos.PerformanceRepository;
import polygon.repos.SessionRepository;
import polygon.repos.TransactionRepository;
import polygon.services.interfaces.SessionService;

import java.sql.Timestamp;
import java.util.*;

@Service
public class SessionServiceImpl implements SessionService {
    private final SessionRepository sessionRepository;
    private final BuildingRepository buildingRepository;
    private final PerformanceRepository performanceRepository;
    private final TransactionRepository transactionRepository;

    private final EmailServiceImpl emailService;
    private final StripeService stripeService;

    public SessionServiceImpl(SessionRepository sessionRepository,
                              BuildingRepository buildingRepository,
                              PerformanceRepository performanceRepository,
                              TransactionRepository transactionRepository,
                              EmailServiceImpl emailService, // TODO: make true service!
                              StripeService stripeService) {
        this.sessionRepository = sessionRepository;
        this.buildingRepository = buildingRepository;
        this.performanceRepository = performanceRepository;
        this.transactionRepository = transactionRepository;
        this.emailService = emailService;
        this.stripeService = stripeService;
    }

    @Override
    public void addSession(Session session) {
        sessionRepository.save(session);
        sessionRepository.flush();
    }

    @Override
    public void addSessions(List<Session> sessions) {
        sessionRepository.saveAll(sessions);
        sessionRepository.flush();
    }

    @Override
    public Map<Building, List<Session>> findBuildingsWithSessionsInCity(Performance performance, City city, Timestamp time) {

        List <Building> buildings = buildingRepository.findByCity(city);
        Map<Building, List<Session>> orderedSessions = new LinkedHashMap<>();
        Calendar ac = Calendar.getInstance();
        ac.setTime(time);
        ac.set(Calendar.HOUR_OF_DAY, 0);
        ac.set(Calendar.MINUTE, 0);
        time = new Timestamp(ac.getTime().getTime());


        Calendar c = Calendar.getInstance();
        c.setTime(time);
        c.add(Calendar.DATE, 1);
        Timestamp endTime = new Timestamp(c.getTime().getTime());
        for (Building b: buildings) {
           List<Session> sessions = sessionRepository.findAllActiveSessionsOnPerformanceForBuilding(b, performance, time, endTime);
           orderedSessions.put(b, sessions);
        }

         return orderedSessions;
    }

    //TODO: GET RID OF THIS SIZE AND getImp.. CANCER!!!!
    @Override
    @Transactional
    public Map<Performance, List<Session>> findSessionsInBuilding(Building building, Timestamp time) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.MILLISECOND, 0);
        Timestamp endTime = new Timestamp(c.getTime().getTime());

        Map<Performance, List<Session>> timestampMap = new LinkedHashMap<>();

        List<Performance> performances = performanceRepository.findAll();
        for (Performance p : performances) {
            p.getCategories().size();
            List<Session> sessions = sessionRepository.findAllActiveSessionsOnPerformanceForBuilding(building, p, time, endTime);
            if (sessions.size() > 0) {
                for (Session session : sessions) {
                    Room room = session.getRoom();
                    Hibernate.initialize(room);

                    if (room instanceof HibernateProxy) {
                        ((HibernateProxy) room).getHibernateLazyInitializer()
                                .getImplementation();
                    }
                }

                timestampMap.put(p, sessions);
            }
        }

        return timestampMap;
    }

    @Override
    @Transactional
    public Session findById(int id) {
        Session s = sessionRepository.findById(id).orElse(null);
        if(s != null) {
            s.getTickets().size();
            Performance performance = s.getPerformance();
            performance.getPreviews().size();

            Hibernate.initialize(performance);
            if (performance instanceof HibernateProxy) {
                ((HibernateProxy) performance).getHibernateLazyInitializer()
                        .getImplementation();
            }

            Room room = s.getRoom();
            Hibernate.initialize(room);
            if (room instanceof HibernateProxy) {
                room = (Room) ((HibernateProxy) room).getHibernateLazyInitializer()
                        .getImplementation();
            }

            Building building = room.getBuilding();
            Hibernate.initialize(room);
            if (building instanceof HibernateProxy) {
                ((HibernateProxy) building).getHibernateLazyInitializer()
                        .getImplementation();
            }
        }
        return s;
    }

    @Override
    @Transactional
    public void cancel(int id) {
        Session session = sessionRepository.findById(id).orElse(null);
        if(session != null) {
            Set<Ticket> tickets = session.getTickets();
            List<TicketsTransaction> ticketsTransactions = transactionRepository.findWithTickets(tickets);

            for (TicketsTransaction ticketsTransaction : ticketsTransactions) {
                ticketsTransaction.setTerminated(true);

                if(ticketsTransaction.isEnded()) {
                    ticketsTransaction.getTickets().size();
                    Ticket ticket = (Ticket) ticketsTransaction.getTickets().toArray()[0];

                    emailService.sendSimpleMessage(ticketsTransaction.getEmail(), "Сеанс отменен",
                            "Сеанс на " + ticket.getSession().getTime() +
                                    " " + ticket.getSession().getPerformance().getName() +
                                    "\nбыл отменен, оформлен возврат средств."
                    );

                    if(ticketsTransaction.getChargeId() != null
                            && ticketsTransaction.getChargeId().length() > 0) {
                        stripeService.refund(ticketsTransaction);
                    }
                }
                transactionRepository.save(ticketsTransaction);
                transactionRepository.flush();
            }

            sessionRepository.delete(session);
            sessionRepository.flush();
        }
    }
}
