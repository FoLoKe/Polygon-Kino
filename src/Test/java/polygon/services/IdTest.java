package polygon.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import polygon.services.interfaces.RoomService;
import polygon.services.interfaces.SessionService;
import polygon.services.interfaces.TicketService;
import polygon.services.interfaces.TransactionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IdTest {

    @Autowired
    private RoomService roomService;
    @Autowired
    private SessionService sessionService;
    @Autowired
    private TicketService ticketService;
    @Autowired
    private TransactionService transactionService;


    @Test
    public void getTicketByIdTest() {
        Object object;
        Integer id=1;
        object=ticketService.getTicketById(id);
        Assert.assertNull(object);
    }

}
