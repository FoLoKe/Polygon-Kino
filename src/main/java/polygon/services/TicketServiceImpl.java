package polygon.services;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.*;
import polygon.repos.TicketRepository;
import polygon.repos.TransactionRepository;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public int setTickets(List<Integer> ids) {
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
    public void addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
        ticketRepository.flush();
    }
}
