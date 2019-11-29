package polygon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polygon.repos.RoomRepository;
import polygon.models.Room;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> allCities() {
        return roomRepository.findAll();
    }

    @Override
    public void add(Room room) {

    }

    @Override
    public void delete(Room room) {
        roomRepository.delete(room);
    }

    @Override
    public void edit(Room room) {

    }

    @Override
    public Room getById(int id) {
        return roomRepository.getOne(id);
    }
}
