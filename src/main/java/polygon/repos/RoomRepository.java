package polygon.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import polygon.models.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}
