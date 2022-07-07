package polygon.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import polygon.models.Performance;

import java.util.List;

public interface CinemaRepository extends JpaRepository<Performance, Integer> {

    @Query("select p from Building p")
    List<Performance> findAllActiveCinemas();

}
