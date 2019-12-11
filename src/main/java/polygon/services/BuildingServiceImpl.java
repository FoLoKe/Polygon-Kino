package polygon.services;

import org.springframework.beans.factory.annotation.Autowired;
import polygon.models.Building;
import polygon.repos.BuildingRepository;

import java.util.List;

public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    public List<Building> allBuildings() {
        return buildingRepository.findAll();
    }

    @Override
    public Building getById(int id) {
        return buildingRepository.getOne(id);
    }
}
