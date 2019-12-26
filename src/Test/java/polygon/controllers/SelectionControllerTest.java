package polygon.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import polygon.models.Room;
import polygon.services.interfaces.RoomService;
import polygon.services.interfaces.SessionService;
import polygon.services.interfaces.TicketService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SelectionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RoomService roomService;

    @MockBean
    private SessionService sessionService;

    @MockBean
    private TicketService ticketService;
    Room room;
    @Test
    public void getPerformance() throws Exception {
        this.mockMvc.perform(get("/selectSeat?id=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("room",room));
    }

    @Test
    public void buyTickets() throws Exception {
        this.mockMvc.perform(get("/buy?ticketsId=21%20"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}