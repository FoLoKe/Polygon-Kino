package polygon.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import polygon.models.Performance;

public interface PerformanceRepository extends JpaRepository<Performance, Integer> {
}
