package polygon.repos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import polygon.models.Room;
import polygon.models.Session;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    Room findBySessions(Session session);
}
