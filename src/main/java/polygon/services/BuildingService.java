package polygon.services;

import polygon.models.Building;

import java.util.List;

public interface BuildingService {

    List<Building> allBuildings();
    Building getById(int id);
}
