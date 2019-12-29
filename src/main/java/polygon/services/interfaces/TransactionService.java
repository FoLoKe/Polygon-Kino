package polygon.services.interfaces;

import polygon.models.TicketsTransaction;

import java.sql.Timestamp;
import java.util.Set;

public interface TransactionService {
    TicketsTransaction findById(int id);
    void save(TicketsTransaction ticketsTransaction);
    Set<TicketsTransaction> findExpired(Timestamp date);
}