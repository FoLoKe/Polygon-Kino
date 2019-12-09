package polygon.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.Ticket;

import java.util.List;


public interface TicketService {

    void setTickets(List<Integer> ids);
    void rollbackTickets(List<Integer> ids);
}
