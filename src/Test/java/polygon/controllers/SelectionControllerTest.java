package polygon.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
import polygon.models.Room;
import polygon.models.Session;
import polygon.models.Ticket;
import polygon.services.interfaces.RoomService;
import polygon.services.interfaces.SessionService;
import polygon.services.interfaces.TicketService;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SelectionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SelectionController controller;

    @Mock
    private RoomService roomService;

    @MockBean
    private SessionService sessionService;

    @MockBean
    private TicketService ticketService;

    @Test
    public void connectionPerformance() throws Exception {
        this.mockMvc.perform(get("//selectSeat?id=1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getPerformance() {
        Session session = new Session();
        Room room = new Room();
        session.setId(1);
        room.setId(1);
        session.setRoom(room);

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -1);
        Timestamp now = new Timestamp(new Date().getTime());

        session.setTime(now);

        org.apache.catalina.User applicationUser = Mockito.mock(org.apache.catalina.User.class);
        Authentication authentication = Mockito.mock(Authentication.class);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        Mockito.when(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).thenReturn(applicationUser);

        Mockito.when(sessionService.findById(1)).thenReturn(session);
//        Mockito.when(roomService.findBySessions(session)).thenReturn(session);
        ModelAndView expected = controller.getPerformance(1);
        Assert.assertNotNull(expected);
    }

    @Test
    public void reserveTickets() {
        Ticket ticket = new Ticket();
        Session session = new Session();
        ticket.setId(1);
        session.setId(1);
        session.setPrice(100);
        ticket.setSession(session);

        org.apache.catalina.User applicationUser = Mockito.mock(org.apache.catalina.User.class);
        Authentication authentication = Mockito.mock(Authentication.class);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        Mockito.when(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).thenReturn(applicationUser);

        Mockito.when(ticketService.getTicketById(1)).thenReturn(ticket);
        ModelAndView expected = controller.reserveTickets("1");
        Assert.assertNotNull(expected);
    }
}