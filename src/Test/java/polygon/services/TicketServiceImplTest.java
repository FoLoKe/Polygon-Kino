package polygon.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import polygon.models.Ticket;
import polygon.repos.TicketRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TicketServiceImplTest {

    @Autowired
    private TicketService ticketService;

    @MockBean
    private TicketRepository ticketRepository;
//    @Mock
//    private Ticket ticket;

    @Test
    public void setTickets() {
        Ticket ticket;
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        ticketService.setTickets(list);
        ticket = ticketRepository.findById(1).orElse(null);
        Assert.assertTrue(ticket.isOccupied());
        Mockito.verify(ticketRepository,Mockito.times(1)).save(ticket);
//        list.add(2);

//        Mockito.doReturn(new Ticket())
//                .when(ticketRepository)
//                .findById(13);
//        Assert.assertTrue(ticket.isOccupied());
//        for (int id : list) {
//            ticket = ticketRepository.findById(id).orElse(null);
////            Assert.assertTrue(ticket.isOccupied());
//            Mockito.verify(ticketRepository,Mockito.times(2)).save(ticket);
//        }
//        Assert.assertTrue(ticket.isOccupied());
//        Ticket ticket = new Ticket();
//        Mockito.verify(ticketRepository,Mockito.times(1)).flush();
    }

    @Test
    public void rollbackTickets() {
        Ticket ticket=new Ticket();
        List<Integer> list = new ArrayList<Integer>();
        list.add(13);
        list.add(14);
        ticketService.rollbackTickets(list);
        Assert.assertFalse(ticket.isOccupied());
//        Mockito.verify(ticketRepository,Mockito.times(1)).flush();
    }
}