package polygon.services.interfaces;

import polygon.models.Ticket;
import polygon.models.User;

import java.util.List;
import java.util.Set;

public interface TicketService {

    int setTickets(List<Integer> ids, User user);
    void rollbackTickets(List<Integer> ids);
    void rollbackTickets(Set<Ticket> tickets);
    Ticket getTicketById(Integer id);
    void addTicket(Ticket ticket);
    Ticket loadTicket(Integer id);
}
