package polygon.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import polygon.models.Room;
import polygon.repos.RoomRepository;

import java.util.Optional;

import static org.mockito.Mockito.mock;

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
    public void findById_Room() {
        Object object = roomService.findById(1);
        Assert.assertNotNull(object);
    }

    @Test
    public void findById_Session() {
        Object object;
        object = sessionService.findById(1);
        Assert.assertNotNull(object);
    }

    @Test
    public void getTicketByIdTest() {
        Object object;
        Integer id=1;
        object=ticketService.getTicketById(id);
        Assert.assertNull(object);
    }

    @Test
    public void findById_Transaction() {
        Object object = transactionService.findById(1);
        Assert.assertNotNull(object);
    }
}
