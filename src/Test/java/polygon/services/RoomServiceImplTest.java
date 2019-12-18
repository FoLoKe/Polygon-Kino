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

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class RoomServiceImplTest {

    @Autowired
    private RoomService roomService;

//    @MockBean
//    private RoomRepository roomRepository;

    @Test
    public void allCities() {
        List<Room> expected=roomService.allCities();
        Assert.assertNotNull(expected);
        Assert.assertEquals(7,expected.size());
    }

    @Test
    public void findBySessions() {
        Session session = new Session();
        Room expected=roomService.findBySessions(session);
        Assert.assertNotNull(expected);
//        Mockito.verify(roomRepository,Mockito.times(1)).findBySessions(session);
//        Assert.assertEquals(2,expected.size());
//        Room room = roomService.findBySessions(session);
//        Assert.assertNotNull(room);
//        Assert.assertEquals(7,room.getSeatsRows().size());
    }
}