package polygon.services;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.Building;
import polygon.models.City;
import polygon.repos.BuildingRepository;
import polygon.services.interfaces.BuildingService;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {
    private final BuildingRepository buildingRepository;

    public BuildingServiceImpl(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    @Override
    @Cacheable
    @Transactional
    public List<Building> allBuildings() {
        List<Building> buildings = buildingRepository.findAll();
        for (Building b : buildings) {
            City city = b.getCity();
            Hibernate.initialize(city);

            if (city instanceof HibernateProxy) {
                ((HibernateProxy) city).getHibernateLazyInitializer()
                        .getImplementation();
            }
        }
        return buildings;
    }

    @Override
    @Transactional
    public List<Building> allByCity(City city) {

        List<Building> buildings = buildingRepository.findByCity(city);
        for (Building b : buildings) {
            City building_city = b.getCity();
            Hibernate.initialize(building_city);

            if (city instanceof HibernateProxy) {
                ((HibernateProxy) building_city).getHibernateLazyInitializer()
                        .getImplementation();
            }
        }
        return buildings;
    }

    @Override
    public Building findById(int id) {
        return buildingRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Building building) {
        buildingRepository.saveAndFlush(building);
    }

    @Override
    public boolean safeDelete(int id) {
        try {
            Building building = buildingRepository.findById(id).orElse(null);

            if(building != null && building.getRooms().size() == 0) {
                buildingRepository.deleteById(id);
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
