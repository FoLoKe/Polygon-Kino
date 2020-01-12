package polygon.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.*;
import polygon.services.EmailServiceImpl;
import polygon.services.interfaces.TicketService;
import polygon.services.interfaces.TransactionService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PaymentController controller;

    @MockBean
    private TicketService ticketService;

    @MockBean
    private EmailServiceImpl emailService;

    @MockBean
    private TransactionService transactionService;

    @Test
    public void payConnection() throws  Exception {
        this.mockMvc.perform(get("/charge"))
                .andDo(print())
                .andExpect(status().is(405));
    }

    @Test
    public void sendEmail() {
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

        performance.setName("Name");
        room.setNumber(100);
        building.setAddress("adress");

        room.setBuilding(building);
        seatsRow.setRoom(room);
        seat.setSeatsRow(seatsRow);
        session.setPerformance(performance);
        ticket.setSession(session);
        ticket.setSeat(seat);

        List<Integer> tickets_ids = new ArrayList<>();
        tickets_ids.add(1);

        String emailText = "Спасибо за покупку!" +
                "\n Ваши билеты на: " + ticket.getSession().getPerformance().getName() +
                "\n Зал №: " + ticket.getSeat().getSeatsRow().getRoom().getNumber() +
                "\n По адресу: " + ticket.getSeat().getSeatsRow().getRoom().getBuilding().getAddress();

        emailText += "\n\nБилет №" + ticket.getId() +
                "\n Ряд: " + ticket.getSeat().getSeatsRow().getRow() +
                "\n Место: " + ticket.getSeat().getSeat();

        Mockito.when(ticketService.loadTicket(1)).thenReturn(ticket);
        controller.sendEmail("email",tickets_ids);
        Mockito.verify(emailService,Mockito.times(1)).sendSimpleMessage("email","Ваши билеты",emailText);
    }

    @Test
    public void refund() {
        TicketsTransaction ticketsTransaction = new TicketsTransaction();
        ticketsTransaction.setId(1);

        org.apache.catalina.User applicationUser = Mockito.mock(org.apache.catalina.User.class);
        Authentication authentication = Mockito.mock(Authentication.class);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        Mockito.when(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).thenReturn(applicationUser);

        Mockito.when(transactionService.findById(1)).thenReturn(ticketsTransaction);
        controller.refund(1);
    }
}