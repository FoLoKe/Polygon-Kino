package polygon.services;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.Building;
import polygon.models.City;
import polygon.repos.BuildingRepository;

import java.util.List;

@Service
public class BuildingServiceImpl implements BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Override
    @Cacheable
    @Transactional
    public List<Building> allBuildings() {
        List<Building> buildings = buildingRepository.findAll();
        for (Building b : buildings) {
            City city = b.getCity();
            Hibernate.initialize(city);

            if (city instanceof HibernateProxy) {
                city = (City) ((HibernateProxy) city).getHibernateLazyInitializer()
                        .getImplementation();
            }
        }
        return buildings;
    }

    @Override
    public Building getById(int id) {
        return buildingRepository.getOne(id);
    }
}
