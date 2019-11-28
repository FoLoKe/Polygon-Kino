package polygon.services;

import org.springframework.beans.factory.annotation.Autowired;
import polygon.repos.BuildingRepository;
import polygon.models.Building;

import java.util.List;

public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;


    @Override
    public List<Building> allBuildings() {
        return buildingRepository.findAll();
    }

    @Override
    public void add(Building building) {
    }

    @Override
    public void delete(Building building) {
        buildingRepository.delete(building);
    }

    @Override
    public void edit(Building building) {
    }

    @Override
    public Building getById(int id) {
        return buildingRepository.getOne(id);
    }
}
