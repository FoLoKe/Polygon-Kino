package polygon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.Room;
import polygon.models.Seat;
import polygon.models.SeatsRow;
import polygon.models.Session;
import polygon.repos.RoomRepository;
import polygon.repos.SeatsRepository;
import polygon.repos.SeatsRowRepository;
import polygon.services.interfaces.RoomService;

import java.util.List;
import java.util.Set;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private SeatsRowRepository seatsRowRepository;

    @Autowired
    private SeatsRepository seatsRepository;

    @Override
    @Transactional
    public List<Room> allRooms() {
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

    @Override
    @Transactional
    public boolean safeDelete(int id) {
        try {
            Room room = roomRepository.findById(id).orElse(null);
            if (room != null) {
                for(SeatsRow sr : room.getSeatsRows()) {
                    for (Seat seat : sr.getSeats()) {
                        seatsRepository.delete(seat);
                        seatsRepository.flush();
                    }
                    seatsRowRepository.delete(sr);
                    seatsRowRepository.flush();
                }

                roomRepository.delete(room);
                roomRepository.flush();
            }

        } catch (Exception e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }

    @Override
    public void save(Room room) {
        roomRepository.save(room);
    }
}
