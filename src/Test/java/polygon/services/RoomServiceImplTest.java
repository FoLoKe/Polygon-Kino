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
import polygon.models.Room;
import polygon.models.Session;
import polygon.repos.RoomRepository;
import polygon.services.interfaces.RoomService;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class RoomServiceImplTest {

    @Autowired
    private RoomService roomService;
    
    @MockBean
    private RoomRepository roomRepository;

    @Test
    public void allCities() {
        List<Room> expected=roomService.allCities();
        Assert.assertNotNull(expected);
        Assert.assertEquals(7,expected.size());
    }

    @Test
    public void findBySessions() {
//        Set<Ticket> tickets=new HashSet<Ticket>();
//        Timestamp timestamp = Timestamp.valueOf("2019-12-19 10:30:00");
//        session.setPrice(100);
//        session.setTime(timestamp);
//        session.setTickets(tickets);
        Session session = new Session();
        Room room = new Room();
        roomService.findBySessions(session);
//        RoomService serviceMock = mock(RoomService.class);
//        Mockito.when(serviceMock.findBySessions(session)).thenReturn(room);

        Assert.assertNotNull(room);
        Mockito.verify(roomRepository,Mockito.times(1)).findBySessions(session);

    }
}