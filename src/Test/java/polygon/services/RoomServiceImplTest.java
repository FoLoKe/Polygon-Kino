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
import polygon.repos.RoomRepository;
import polygon.repos.SessionRepository;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class RoomServiceImplTest {

    @Autowired
    private RoomService roomService;

    @MockBean
    private RoomRepository roomRepository;

    @MockBean
    private SessionRepository sessionRepository;

    @Test
    public void allCities() {
        Room room = new Room();
        room.setId(1);
        List<Room> rooms =List.of(room);
        RoomRepository roomRepositoryMock = mock(RoomRepository.class);
        Mockito.when(roomRepositoryMock.findAll()).thenReturn(rooms);
        List<Room> expected=roomService.allCities();
        Assert.assertNotNull(expected);
        Mockito.verify(roomRepository,Mockito.times(1)).findAll();
    }

    @Test
    public void findBySessions() {
        Session session = new Session();
        session.setId(1);
        Set<Session> sessions =Set.of(session);
        Room room = new Room();
        room.setId(1);
        room.setSessions(sessions);
        RoomRepository roomRepositoryMock = mock(RoomRepository.class);
        Mockito.when(roomRepositoryMock.findBySessions(session)).thenReturn(room);
        Room expected = roomService.findBySessions(session);
        Assert.assertNotNull(expected);
        Mockito.verify(roomRepository,Mockito.times(1)).findBySessions(session);
    }

//    @Test
//    public void findById() {
//        Room room = new Room();
//        room.setId(1);
//        RoomRepository roomRepositoryMock = mock(RoomRepository.class);
//        Mockito.when(roomRepositoryMock.findById(1)).thenReturn(Optional.of(room));
//        Object object = roomService.findById(1);
//        Assert.assertNotNull(object);
//    }
}