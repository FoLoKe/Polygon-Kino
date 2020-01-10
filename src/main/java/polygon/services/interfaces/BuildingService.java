package polygon.services.interfaces;

import polygon.models.Building;
import polygon.models.City;

import java.util.List;

public interface BuildingService {
    List<Building> allBuildings();
    Building findById(int id);
    List<Building> allByCity(City city);

    void save(Building building);
    boolean safeDelete(int id);
}
