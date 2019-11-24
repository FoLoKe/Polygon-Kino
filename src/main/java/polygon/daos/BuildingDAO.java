package polygon.daos;

import org.springframework.stereotype.Repository;
import polygon.models.Building;

import java.util.List;

@Repository
public interface BuildingDAO {
    List<Building> getAllBuildings();
    void add(Building building);
    void delete(Building building);
    void edit(Building building);
    Building getByID(int id);
}
