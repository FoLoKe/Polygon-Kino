package polygon.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import polygon.models.Building;

import java.util.List;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {

}
