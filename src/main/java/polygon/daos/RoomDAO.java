package polygon.daos;

import org.springframework.stereotype.Repository;
import polygon.models.Room;

import java.util.List;

@Repository
public interface RoomDAO {
    List<Room> allRooms();
    void add(Room room);
    void delete(Room room);
    void edit(Room room);
    Room getByID(int id);
}
