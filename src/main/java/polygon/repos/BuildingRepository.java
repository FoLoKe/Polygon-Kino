package polygon.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import polygon.models.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {

}
