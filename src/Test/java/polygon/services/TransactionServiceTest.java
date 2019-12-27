package polygon.services;

import org.h2.mvstore.tx.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import polygon.models.Ticket;
import polygon.models.TicketsTransaction;
import polygon.repos.TransactionRepository;

import static org.junit.Assert.*;
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
}