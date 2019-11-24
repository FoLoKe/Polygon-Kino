package polygon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import polygon.daos.RoomDAO;
import polygon.models.Room;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDAO cityDAO;

    @Override
    public List<Room> allCities() {
        return cityDAO.allRooms();
    }

    @Override
    public void add(Room room) {
        cityDAO.add(room);
    }

    @Override
    public void delete(Room room) {
        cityDAO.delete(room);
    }

    @Override
    public void edit(Room room) {
        cityDAO.edit(room);
    }

    @Override
    public Room getById(int id) {
        return cityDAO.getByID(id);
    }
}
