package polygon.services;

import polygon.models.Building;
import polygon.models.City;

import java.util.List;

public interface BuildingService {
    List<Building> allBuildings();
    Building getById(int id);
    List<Building> allByCity(City city);
}
