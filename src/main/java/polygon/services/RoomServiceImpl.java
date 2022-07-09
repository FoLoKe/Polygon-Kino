package polygon.services;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.*;
import polygon.repos.RoomRepository;
import polygon.repos.SeatRepository;
import polygon.repos.SeatsRowRepository;
import polygon.services.interfaces.RoomService;

import java.util.List;
import java.util.Set;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;
    private final SeatsRowRepository seatsRowRepository;
    private final SeatRepository seatsRepository;

    public RoomServiceImpl(RoomRepository roomRepository,
                           SeatsRowRepository seatsRowRepository,
                           SeatRepository seatsRepository) {
        this.roomRepository = roomRepository;
        this.seatsRowRepository = seatsRowRepository;
        this.seatsRepository = seatsRepository;
    }

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

            Building building = room.getBuilding();
            Hibernate.initialize(building);

            if (building instanceof HibernateProxy) {
                building = (Building) ((HibernateProxy) building).getHibernateLazyInitializer()
                        .getImplementation();
                City city = building.getCity();

                Hibernate.initialize(city);

                if (city instanceof HibernateProxy) {
                    ((HibernateProxy) city).getHibernateLazyInitializer()
                            .getImplementation();
                }
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
            if (room != null && room.getSessions().size() == 0) {
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
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    @Override
    public void save(Room room) {
        roomRepository.save(room);
    }
}
