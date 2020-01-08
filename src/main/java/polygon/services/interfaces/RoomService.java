package polygon.services.interfaces;

import polygon.models.Room;
import polygon.models.Session;

import java.util.List;

public interface RoomService {

    List<Room> allRooms();
    Room findBySessions(Session session);
    Room findById(int id);

    boolean safeDelete(int id);
    void save(Room room);
}
