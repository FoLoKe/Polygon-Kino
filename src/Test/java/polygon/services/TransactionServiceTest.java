package polygon.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import polygon.models.*;
import polygon.repos.TransactionRepository;
import polygon.services.interfaces.TransactionService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @MockBean
    TransactionRepository transactionRepository;

    @Test
    public void save() {
        TicketsTransaction ticketsTransaction = new TicketsTransaction();
        transactionService.save(ticketsTransaction);
        Mockito.verify(transactionRepository,Mockito.times(1)).save(ticketsTransaction);
        Mockito.verify(transactionRepository,Mockito.times(1)).flush();
    }

    @Test
    public void findById() {
        TicketsTransaction ticketsTransaction = new TicketsTransaction();
        Ticket ticket = new Ticket();
        ticket.setId(1);
        ticketsTransaction.setId(1);
        Set<Ticket> tickets =Set.of(ticket);
        ticketsTransaction.setTickets(tickets);
        Mockito.when(transactionRepository.findById(1)).thenReturn(Optional.of(ticketsTransaction));
        TicketsTransaction expected = transactionService.findById(1);
        Assert.assertNotNull(expected);
    }

    @Test
    public void findExpired() {
        TicketsTransaction ticketsTransaction = new TicketsTransaction();
        Ticket ticket = new Ticket();
        ticket.setId(1);
        ticketsTransaction.setId(1);
        Set<Ticket> tickets =Set.of(ticket);
        ticketsTransaction.setTickets(tickets);
        Set<TicketsTransaction> ticketsTransactions =Set.of(ticketsTransaction);
        java.util.Date utilDate = new java.util.Date(System.currentTimeMillis());
        java.sql.Timestamp time = new java.sql.Timestamp(utilDate.getTime());
        Mockito.when(transactionRepository.findExpired(time)).thenReturn(ticketsTransactions);
        Set<TicketsTransaction> expected = transactionService.findExpired(time);
        Assert.assertNotNull(expected);
        Assert.assertEquals(1,expected.size());
    }

    @Test
    public void allTransactions() {
        TicketsTransaction ticketsTransaction = new TicketsTransaction();
        User user = new User();
        ticketsTransaction.setId(1);
        user.setId(1);
        ticketsTransaction.setUser(user);
        List<TicketsTransaction> ticketsTransactions = List.of(ticketsTransaction);
        Mockito.when(transactionRepository.findAll()).thenReturn(ticketsTransactions);
        List<TicketsTransaction> expected=transactionService.allTransactions();
        Assert.assertNotNull(expected);
        Assert.assertEquals(1,expected.size());
    }

    @Test
    public void findByUser() {
        TicketsTransaction ticketsTransaction = new TicketsTransaction();
        User user = new User();
        Ticket ticket = new Ticket();
        Session session = new Session();
        ticket.setId(1);
        ticketsTransaction.setId(1);
        user.setId(1);
        session.setId(1);
        ticket.setSession(session);
        ticketsTransaction.setUser(user);
        Set<Ticket> tickets =Set.of(ticket);
        ticketsTransaction.setTickets(tickets);
        List<TicketsTransaction> ticketsTransactions = List.of(ticketsTransaction);
        Mockito.when(transactionRepository.findWithUser(user)).thenReturn(ticketsTransactions);
        List<TicketsTransaction> expected=transactionService.findByUser(user);
        Assert.assertNotNull(expected);
        Assert.assertEquals(1,expected.size());
    }

}