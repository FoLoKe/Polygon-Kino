package polygon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.Ticket;
import polygon.repos.TicketRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public boolean setTickets(List<Integer> ids) {
        List<Ticket> tickets = new ArrayList<>();
        for (int id : ids) {
            Ticket ticket = ticketRepository.findById(id).orElse(null);
            if(ticket != null && !ticket.isOccupied()) {
                ticket.setOccupied(true);
                tickets.add(ticket);
            } else {
                return false;
            }
        }
        ticketRepository.saveAll(tickets);
        ticketRepository.flush();
        return true;
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
}
