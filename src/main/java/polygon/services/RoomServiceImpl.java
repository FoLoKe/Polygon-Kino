package polygon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.SeatsRow;
import polygon.models.Session;
import polygon.repos.RoomRepository;
import polygon.models.Room;

import java.util.List;
import java.util.Set;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> allCities() {
        return roomRepository.findAll();
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
}
