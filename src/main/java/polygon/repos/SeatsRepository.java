package polygon.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import polygon.models.Seat;

public interface SeatsRepository extends JpaRepository<Seat, Integer> {
}
