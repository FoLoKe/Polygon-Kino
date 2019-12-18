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

    @Mock
    private RoomRepository roomRepository;

    @Test
    public void allCities() {
        List<Room> expected=roomService.allCities();
        Assert.assertNotNull(expected);
        Assert.assertEquals(7,expected.size());
    }

    @Test
    public void findBySessions() {
        Session session = new Session();
        roomService.findBySessions(session);
        Mockito.verify(roomRepository,Mockito.times(1)).findBySessions(session);
    }
}