package polygon.services;

import org.springframework.beans.factory.annotation.Autowired;
import polygon.daos.BuildingDAO;
import polygon.models.Building;

import java.util.List;

public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingDAO buildingDAO;


    @Override
    public List<Building> allBuildings() {
        return buildingDAO.getAllBuildings();
    }

    @Override
    public void add(Building building) {
        buildingDAO.add(building);
    }

    @Override
    public void delete(Building building) {
        buildingDAO.delete(building);
    }

    @Override
    public void edit(Building building) {
        buildingDAO.edit(building);
    }

    @Override
    public Building getById(int id) {
        return buildingDAO.getByID(id);
    }
}
