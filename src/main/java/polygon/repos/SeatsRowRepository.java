package polygon.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import polygon.models.SeatsRow;

public interface SeatsRowRepository extends JpaRepository<SeatsRow, Integer> {
}
