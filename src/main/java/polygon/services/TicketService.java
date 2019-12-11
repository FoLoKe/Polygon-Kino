package polygon.services;

import java.util.List;

public interface TicketService {

    void setTickets(List<Integer> ids);
    void rollbackTickets(List<Integer> ids);
}
