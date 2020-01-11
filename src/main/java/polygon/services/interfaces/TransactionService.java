package polygon.services.interfaces;

import polygon.models.TicketsTransaction;
import polygon.models.User;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public interface TransactionService {
    TicketsTransaction findById(int id);
    void save(TicketsTransaction ticketsTransaction);
    Set<TicketsTransaction> findExpired(Timestamp date);

    List<TicketsTransaction> allTransactions();
    List<TicketsTransaction> findByUser(User user);
}
