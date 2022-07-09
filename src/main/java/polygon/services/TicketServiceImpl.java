package polygon.services;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.*;
import polygon.repos.TicketRepository;
import polygon.repos.TransactionRepository;
import polygon.services.interfaces.TicketService;

import java.util.*;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TransactionRepository transactionRepository;

    public TicketServiceImpl(TicketRepository ticketRepository,
                             TransactionRepository transactionRepository) {
        this.ticketRepository = ticketRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public int setTickets(List<Integer> ids, User user) {
        List<Ticket> tickets = new ArrayList<>();
        Set<Ticket> transaction = new LinkedHashSet<>();
        for (int id : ids) {
            Ticket ticket = ticketRepository.findById(id).orElse(null);
            if(ticket != null && !ticket.isOccupied()) {
                ticket.setOccupied(true);
                tickets.add(ticket);
                transaction.add(ticket);
            } else {
                return -1;
            }
        }

        TicketsTransaction ticketsTransaction = new TicketsTransaction();
        ticketsTransaction.setEnded(false);
        ticketsTransaction.setTickets(transaction);
        ticketsTransaction.setDate(new java.sql.Timestamp(new Date().getTime()));
        ticketsTransaction.setUser(user);
        ticketsTransaction.setTerminated(false);

        transactionRepository.save(ticketsTransaction);
        transactionRepository.flush();

        ticketRepository.saveAll(tickets);
        ticketRepository.flush();
        return ticketsTransaction.getId();
    }

    @Override
    public Ticket getTicketById(Integer id) {
        Ticket ticket = ticketRepository.findById(id).orElse(null);
        if(ticket != null) {
            ticket.getSession().getPrice();
        }
        return ticket;
    }

    @Override
    @Transactional
    public Ticket loadTicket(Integer id) {
        Ticket ticket = ticketRepository.findById(id).orElse(null);
        if(ticket != null) {
            ticket.getSession().getPrice();
            Seat seat = ticket.getSeat();
            Hibernate.initialize(seat);
            if (seat instanceof HibernateProxy) {
                seat = (Seat) ((HibernateProxy) seat).getHibernateLazyInitializer()
                        .getImplementation();
            }

            SeatsRow seatsRow = seat.getSeatsRow();
            if (seatsRow instanceof HibernateProxy) {
                seatsRow = (SeatsRow) ((HibernateProxy) seatsRow).getHibernateLazyInitializer()
                        .getImplementation();
            }

            Room room = seatsRow.getRoom();
            if (room instanceof HibernateProxy) {
                room = (Room) ((HibernateProxy) room).getHibernateLazyInitializer()
                        .getImplementation();
            }

            Building building = room.getBuilding();
            if (building instanceof HibernateProxy) {
                building = (Building) ((HibernateProxy) building).getHibernateLazyInitializer()
                        .getImplementation();
            }

            Session session = ticket.getSession();
            if (session instanceof HibernateProxy) {
                session = (Session) ((HibernateProxy) session).getHibernateLazyInitializer()
                        .getImplementation();
            }

            Performance performance = session.getPerformance();
            if (performance instanceof HibernateProxy) {
                performance = (Performance) ((HibernateProxy) performance).getHibernateLazyInitializer()
                        .getImplementation();
            }
        }
        return ticket;
    }

    @Override
    public void rollbackTickets(List<Integer> ids) {
        for (int id : ids) {
            Ticket ticket = ticketRepository.findById(id).orElse(null);
            if(ticket != null && ticket.isOccupied()) {
                ticket.setOccupied(false);
                ticketRepository.save(ticket);
                ticketRepository.flush();
            }
        }
    }

    @Override
    public void rollbackTickets(Set<Ticket> tickets) {
        for (Ticket ticket : tickets) {
            ticket.setOccupied(false);
            ticketRepository.save(ticket);
            ticketRepository.flush();
        }
    }

    @Override
    public void addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
        ticketRepository.flush();
    }
}
