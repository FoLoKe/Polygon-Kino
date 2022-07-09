package polygon.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import polygon.models.Ticket;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
