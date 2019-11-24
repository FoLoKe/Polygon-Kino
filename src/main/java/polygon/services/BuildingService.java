package polygon.services;

import org.springframework.stereotype.Service;
import polygon.models.Building;

import java.util.List;

@Service
public interface BuildingService {
    List<Building> allBuildings();
    void add(Building building);
    void delete(Building building);
    void edit(Building building);
    Building getById(int id);
}
