package polygon.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import polygon.models.Ticket;
import polygon.models.TicketsTransaction;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public interface TransactionRepository extends JpaRepository<TicketsTransaction, Integer> {
    @Query("select t from TicketsTransaction t where t.ended = false and t.terminated = false and t.date <= :date")
    Set<TicketsTransaction> findExpired(Timestamp date);

    @Query("select t from TicketsTransaction t join t.tickets as ti where ti in (:tickets)")
    List<TicketsTransaction> findWithTickets(@Param("tickets") Set<Ticket> tickets);
}
