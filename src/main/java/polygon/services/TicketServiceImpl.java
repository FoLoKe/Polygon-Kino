package polygon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.Ticket;
import polygon.repos.TicketRepository;

import java.util.List;

@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void setTickets(List<Integer> ids) {
        for (int id : ids) {
            Ticket ticket = ticketRepository.findById(id).orElse(null);
            if(ticket != null && !ticket.isOccupied()) {
                ticket.setOccupied(true);
                ticketRepository.save(ticket);
            }
        }
        ticketRepository.flush();
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
