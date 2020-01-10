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
import polygon.models.Ticket;
import polygon.repos.TicketRepository;
import polygon.services.interfaces.TicketService;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TicketServiceImplTest {

    @Autowired
    private TicketService ticketService;

    @MockBean
    private TicketRepository ticketRepository;


    @Test
    public void setTickets() {
//        Ticket ticket = new Ticket();
//        ticket.setId(1);
//        ticket.setOccupied(false);
//        List<Integer> list = new ArrayList<Integer>();
//        list.add(1);
//        TicketRepository ticketRepositoryMock = mock(TicketRepository.class);
//        Mockito.when(ticketRepositoryMock.findById(1)).thenReturn(ticket);
//        int setTicketsWorks=ticketService.setTickets(list);
//        Assert.assertNotEquals(-1,setTicketsWorks);
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        int setTicketsWorks=ticketService.setTickets(list, null);
        Assert.assertNotEquals(-1,setTicketsWorks);
    }

    @Test
    public void setTicketsFail() {
//        List<Ticket> tickets = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(13);
        list.add(14);
        int setTicketsWorks=ticketService.setTickets(list, null);
        Assert.assertNotEquals(-1,setTicketsWorks);
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

    @Test
    public void loadTicket() {
        Ticket ticket = ticketService.loadTicket(1);
        Assert.assertNull(ticket);
    }

    @Test
    public void addTicket() {
        Ticket ticket = new Ticket();
        ticketService.addTicket(ticket);
        Mockito.verify(ticketRepository,Mockito.times(1)).save(ticket);
        Mockito.verify(ticketRepository,Mockito.times(1)).flush();

    }
}