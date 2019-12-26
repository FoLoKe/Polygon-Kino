package polygon.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import polygon.models.Ticket;
import polygon.services.interfaces.TicketService;

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
        int setTicketsWorks=ticketService.setTickets(list);
        Assert.assertNotEquals(-1,setTicketsWorks);
    }

    @Test
    public void setTicketsFail() {
//        List<Ticket> tickets = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(13);
        list.add(14);
        int setTicketsWorks=ticketService.setTickets(list);
        Assert.assertNotEquals(-1,setTicketsWorks);
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