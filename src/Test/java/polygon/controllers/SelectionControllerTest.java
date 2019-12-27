package polygon.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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

    @Autowired
    private SelectionController controller;

    @Mock
    private RoomService roomService;

    @Mock
    private SessionService sessionService;

    @Mock
    private TicketService ticketService;
    Room room;

    @Test
    public void getPerformance() throws Exception {
        this.mockMvc.perform(get("//selectSeat?id=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("room",room));
    }

    @Test
    public void buyTickets() throws Exception {
        this.mockMvc.perform(get("//pay?id=2"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}