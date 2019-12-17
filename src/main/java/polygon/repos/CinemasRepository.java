package polygon.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import polygon.models.Performance;

import java.sql.Date;
import java.util.List;

public interface CinemasRepository extends JpaRepository<Performance, Integer> {

    @Query("select p from Building p")
    List<Performance> findAllActiveCinemas();

}
