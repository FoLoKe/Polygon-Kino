package polygon.services;

import polygon.models.Ticket;

import java.util.List;

public interface TicketService {

    int setTickets(List<Integer> ids);
    void rollbackTickets(List<Integer> ids);
    Ticket getTicketById(Integer id);
    void addTicket(Ticket ticket);
    Ticket loadTicket(Integer id);
}
