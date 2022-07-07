package polygon.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import polygon.models.Seat;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
}
