package polygon.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import polygon.models.Ticket;
import polygon.repos.TicketRepository;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TicketServiceImplTest {

    @Autowired
    private TicketService ticketService;

//    @MockBean
//    private TicketRepository ticketRepository;


    @Test
    public void setTickets() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        boolean setTicketsWorks=ticketService.setTickets(list);
        Assert.assertTrue(setTicketsWorks);
    }

    @Test
    public void setTicketsFail() {
//        List<Ticket> tickets = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(13);
        list.add(14);
        boolean setTicketsWorks = ticketService.setTickets(list);
        Assert.assertFalse(setTicketsWorks);
    }

    @Test
    public void getTicketByIdTest() {
        Object object;
        Integer id=1;
        object=ticketService.getTicketById(id);
        Assert.assertNotNull(object);
    }

    @Test
    public void rollbackTickets() {
        Ticket ticket=new Ticket();
        List<Integer> list = new ArrayList<Integer>();
        list.add(13);
        list.add(14);
        ticketService.rollbackTickets(list);
        Assert.assertFalse(ticket.isOccupied());
    }
}