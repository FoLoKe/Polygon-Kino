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
import polygon.repos.TicketRepository;
import polygon.repos.TransactionRepository;
import polygon.services.interfaces.TicketService;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TicketServiceImplTest {

    @Autowired
    private TicketService ticketService;

    @MockBean
    private TicketRepository ticketRepository;

    @MockBean
    private TransactionRepository transactionRepository;


    @Test
    public void setTickets() {
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        User user = new User();
        ticket1.setId(1);
        ticket2.setId(2);
        ticket1.setOccupied(false);
        ticket2.setOccupied(false);
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        Set<Ticket> transaction = Set.of(ticket1);
        Mockito.when(ticketRepository.findById(1)).thenReturn(Optional.of(ticket1));
        int setTicketsWorks=ticketService.setTickets(list, user);
        Assert.assertNotEquals(-1,setTicketsWorks);
    }

    @Test
    public void setTicketsFail() {
//        List<Ticket> tickets = new ArrayList<>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(13);
        list.add(14);
        int setTicketsWorks=ticketService.setTickets(list, null);
        Assert.assertEquals(-1,setTicketsWorks);
    }


    @Test
    public void getTicketById() {
        Ticket ticket = new Ticket();
        Session session = new Session();
        session.setPrice(250);
        ticket.setId(1);
        ticket.setSession(session);
        Mockito.when(ticketRepository.findById(1)).thenReturn(Optional.of(ticket));
        Ticket expected = ticketService.getTicketById(1);
        Assert.assertNotNull(expected);
        Mockito.verify(ticketRepository,Mockito.times(1)).findById(1);
    }


    @Test
    public void rollbackTickets1() {
        Ticket ticket=new Ticket();
        ticket.setId(1);
        ticket.setOccupied(true);
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        Mockito.when(ticketRepository.findById(1)).thenReturn(Optional.of(ticket));
        ticketService.rollbackTickets(list);
        Assert.assertFalse(ticket.isOccupied());
        Mockito.verify(ticketRepository,Mockito.times(1)).save(ticket);
        Mockito.verify(ticketRepository,Mockito.times(1)).flush();
    }

    @Test
    public void rollbackTickets2() {
        Ticket ticket=new Ticket();
        ticket.setId(1);
        ticket.setOccupied(true);
        Set<Ticket> tickets = Set.of(ticket);
        Mockito.when(ticketRepository.findById(1)).thenReturn(Optional.of(ticket));
        ticketService.rollbackTickets(tickets);
        Assert.assertFalse(ticket.isOccupied());
        Mockito.verify(ticketRepository,Mockito.times(1)).save(ticket);
        Mockito.verify(ticketRepository,Mockito.times(1)).flush();
    }

    @Test
    public void loadTicket() {
        Ticket ticket = new Ticket();
        Session session = new Session();
        Room room = new Room();
        SeatsRow seatsRow = new SeatsRow();
        Seat seat = new Seat();
        Building building = new Building();
        Performance performance = new Performance();

        session.setPrice(250);
        session.setId(1);
        ticket.setId(1);
        seatsRow.setId(1);
        seat.setId(1);
        room.setId(1);
        building.setId(1);
        performance.setId(1);

        room.setBuilding(building);
        seatsRow.setRoom(room);
        seat.setSeatsRow(seatsRow);
        session.setPerformance(performance);
        ticket.setSession(session);
        ticket.setSeat(seat);

        Mockito.when(ticketRepository.findById(1)).thenReturn(Optional.of(ticket));
        Ticket expected = ticketService.loadTicket(1);
        Assert.assertNotNull(expected);
        Mockito.verify(ticketRepository,Mockito.times(1)).findById(1);
    }

    @Test
    public void addTicket() {
        Ticket ticket = new Ticket();
        ticketService.addTicket(ticket);
        Mockito.verify(ticketRepository,Mockito.times(1)).save(ticket);
        Mockito.verify(ticketRepository,Mockito.times(1)).flush();

    }
}