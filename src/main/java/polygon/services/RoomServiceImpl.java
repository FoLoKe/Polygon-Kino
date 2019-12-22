package polygon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.Room;
import polygon.models.SeatsRow;
import polygon.models.Session;
import polygon.repos.RoomRepository;

import java.util.List;
import java.util.Set;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    @Transactional
    public List<Room> allCities() {
        List<Room> rooms = roomRepository.findAll();
        for(Room room : rooms) {
            room.getSeatsRows().size();
            Set<SeatsRow> seatsRows = room.getSeatsRows();
            for (SeatsRow sr : seatsRows) {
                sr.getSeats().size();
            }
        }
        return rooms;
    }

    @Override
    @Transactional
    public Room findBySessions(Session session) {
        Room room = roomRepository.findBySessions(session);
        room.getSeatsRows().size();
        Set<SeatsRow> seatsRows = room.getSeatsRows();
        for (SeatsRow sr : seatsRows) {
            sr.getSeats().size();
        }

        return room;
    }

    @Override
    @Transactional
    public Room findById(int id) {
        Room room = roomRepository.findById(id).orElse(new Room());
        room.getSeatsRows().size();
        Set<SeatsRow> seatsRows = room.getSeatsRows();
        for (SeatsRow sr : seatsRows) {
            sr.getSeats().size();
        }
        return room;
    }
}
