package polygon.services;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.Session;
import polygon.models.Ticket;
import polygon.models.TicketsTransaction;
import polygon.models.User;
import polygon.repos.TransactionRepository;
import polygon.services.interfaces.TransactionService;

import java.sql.Timestamp;
import java.util.List;
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

    @Override
    @Transactional
    public List<TicketsTransaction> allTransactions() {
        List<TicketsTransaction> ticketsTransactions = transactionRepository.findAll();
        for (TicketsTransaction ticketsTransaction : ticketsTransactions) {
            User user = ticketsTransaction.getUser();
            if(ticketsTransaction.getUser() != null) {
                Hibernate.initialize(user);

                if (user instanceof HibernateProxy) {
                    user = (User) ((HibernateProxy) user).getHibernateLazyInitializer()
                            .getImplementation();
                }
            }
        }
        return ticketsTransactions;
    }

    @Override
    @Transactional
    public List<TicketsTransaction> findByUser(User user) {
        List<TicketsTransaction> ticketsTransactions = transactionRepository.findWithUser(user);
        for(TicketsTransaction ticketsTransaction : ticketsTransactions) {
            Set<Ticket> tickets = ticketsTransaction.getTickets();
            tickets.size();
            for (Ticket ticket : tickets) {
                Hibernate.initialize(ticket);

                if (ticket instanceof HibernateProxy) {
                    ticket = (Ticket) ((HibernateProxy) ticket).getHibernateLazyInitializer()
                            .getImplementation();
                }
                Session session = ticket.getSession();
                Hibernate.initialize(session);

                if (session instanceof HibernateProxy) {
                    session = (Session) ((HibernateProxy) session).getHibernateLazyInitializer()
                            .getImplementation();
                }
            }
        }
        return ticketsTransactions;
    }
}
