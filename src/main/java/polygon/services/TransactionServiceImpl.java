package polygon.services;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.Session;
import polygon.models.Ticket;
import polygon.models.TicketsTransaction;
import polygon.repos.TransactionRepository;
import polygon.services.interfaces.TransactionService;

import java.sql.Timestamp;
import java.util.Set;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Override
    @Transactional
    public TicketsTransaction findById(int id){
        TicketsTransaction ticketsTransaction = transactionRepository.findById(id).orElse(null);
        if(ticketsTransaction != null) {
            ticketsTransaction.getTickets().size();
            Set<Ticket> tickets = ticketsTransaction.getTickets();
            for(Ticket t: tickets) {
                Hibernate.initialize(t);
                Session session = t.getSession();
                if (session instanceof HibernateProxy) {
                    session = (Session) ((HibernateProxy) session).getHibernateLazyInitializer()
                            .getImplementation();
                }
            }
        }
        return ticketsTransaction;
    }

    @Override
    @Transactional
    public void save(TicketsTransaction ticketsTransaction) {
        transactionRepository.save(ticketsTransaction);
        transactionRepository.flush();
    }

    @Override
    @Transactional
    public Set<TicketsTransaction> findExpired(Timestamp date) {
        Set<TicketsTransaction> ticketsTransactions = transactionRepository.findExpired(date);
        for (TicketsTransaction ticketsTransaction : ticketsTransactions) {
            ticketsTransaction.getTickets().size();
        }
        return ticketsTransactions;
    }
}
