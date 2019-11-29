package polygon.services;

import org.springframework.stereotype.Service;
import polygon.models.Room;

import java.util.List;

public interface RoomService {
    List<Room> allCities();
    void add(Room room);
    void delete(Room room);
    void edit(Room room);
    Room getById(int id);
}
