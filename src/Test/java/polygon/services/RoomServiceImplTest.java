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
import polygon.models.Seat;
import polygon.models.SeatsRow;
import polygon.models.Session;
import polygon.repos.RoomRepository;
import polygon.repos.SessionRepository;
import polygon.services.interfaces.RoomService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
        SeatsRow seatsRow = new SeatsRow();
        Seat seat = new Seat();
        room.setId(1);
        seatsRow.setId(1);
        seat.setId(1);
        Set<SeatsRow> seatsRows = Set.of(seatsRow);
        Set<Seat> seats = Set.of(seat);
        seatsRow.setSeats(seats);
        room.setSeatsRows(seatsRows);
        List<Room> rooms =List.of(room);
        Mockito.when(roomRepository.findAll()).thenReturn(rooms);
        List<Room> expected=roomService.allCities();
        Assert.assertNotNull(expected);
        Assert.assertEquals(1,expected.size());
        Mockito.verify(roomRepository,Mockito.times(1)).findAll();
    }

    @Test
    public void findBySessions() {
        Session session = new Session();
        SeatsRow seatsRow = new SeatsRow();
        Seat seat = new Seat();
        seatsRow.setRow(3);
        seat.setSeat(3);
        session.setId(1);
        Set<Session> sessions = Set.of(session);
        Set<SeatsRow> seatsRows = Set.of(seatsRow);
        Set<Seat> seats = Set.of(seat);
        seatsRow.setSeats(seats);
        Room room = new Room();
        room.setId(1);
        room.setSeatsRows(seatsRows);
        room.setSessions(sessions);
//        RoomRepository roomRepositoryMock = mock(RoomRepository.class);
        Mockito.when(roomRepository.findBySessions(session)).thenReturn(room);
        Room expected = roomService.findBySessions(session);
        Assert.assertNotNull(expected);
        Mockito.verify(roomRepository,Mockito.times(1)).findBySessions(session);
    }

    @Test
    public void findById() {
        Room room = new Room();
        SeatsRow seatsRow = new SeatsRow();
        Seat seat = new Seat();
        room.setId(1);
        seatsRow.setId(1);
        seat.setId(1);
        Set<SeatsRow> seatsRows = Set.of(seatsRow);
        Set<Seat> seats = Set.of(seat);
        seatsRow.setSeats(seats);
        room.setSeatsRows(seatsRows);
        Mockito.when(roomRepository.findById(1)).thenReturn(Optional.of(room));
        Room expected = roomService.findById(1);
        Assert.assertNotNull(expected);
        Mockito.verify(roomRepository,Mockito.times(1)).findById(1);
    }
}