package polygon.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import polygon.models.TicketsTransaction;

public interface TransactionRepository extends JpaRepository<TicketsTransaction, Integer> {
}
