package polygon.services;

import org.springframework.stereotype.Service;
import polygon.models.Room;
import polygon.models.Session;

import java.util.List;

public interface RoomService {
    List<Room> allCities();
    Room findBySessions(Session session);
}
