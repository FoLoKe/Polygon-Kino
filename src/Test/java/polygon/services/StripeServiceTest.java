package polygon.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import polygon.models.Session;
import polygon.models.Ticket;
import polygon.models.TicketsTransaction;

import java.util.Set;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StripeServiceTest {

    @Autowired
    private StripeService stripeService;

    @Test
    public void chargeNewCard() {
//        Charge charge1 = new Charge();
//        String token = "token";
//        double amount = 100;
//        Map<String, Object> chargeParams = new HashMap<String, Object>();
//        chargeParams.put("amount", (int)(amount * 100));
//        chargeParams.put("currency", "USD");
//        chargeParams.put("source", token);
//        Mockito.when(charge.create(chargeParams)).thenReturn(charge1);
//        Charge expected = stripeService.chargeNewCard(token,amount);
//        Assert.assertNotNull(expected);
    }

    @Test
    public void refund() {
        TicketsTransaction ticketsTransaction = new TicketsTransaction();
        Ticket ticket = new Ticket();
        Session session = new Session();
        ticket.setId(1);
        ticketsTransaction.setId(1);
        session.setId(1);
        session.setPrice(100);
        Set<Ticket> tickets =Set.of(ticket);
        ticket.setSession(session);
        ticketsTransaction.setTickets(tickets);
        ticketsTransaction.setChargeId("1");
        ticketsTransaction.setRefunded(false);
        ticketsTransaction.setByBalance(false);
        ticketsTransaction.setEnded(true);
        stripeService.refund(ticketsTransaction);
        Assert.assertFalse(ticketsTransaction.isRefunded());
    }
}