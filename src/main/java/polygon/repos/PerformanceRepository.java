package polygon.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import polygon.models.Performance;

import java.sql.Date;
import java.util.List;

public interface PerformanceRepository extends JpaRepository<Performance, Integer> {
    @Query("select p from Performance p where p.date >= :date")
    List<Performance> findAllActivePerformances(@Param("date") Date date);
}
