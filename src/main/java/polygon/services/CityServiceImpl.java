package polygon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.City;
import polygon.repos.CityRepository;
import polygon.services.interfaces.CityService;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    @Transactional
    @Cacheable
    public List<City> allCities() {
        List<City> cities = cityRepository.findAll();
        for(City c : cities) {
            c.getBuildings().size();
        }
        return cities;
    }

    @Override
    @Transactional
    public City findById(int id) {
        return cityRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public boolean safeDelete(int id) {
        try {
            City city = cityRepository.findById(id).orElse(null);
            if(city != null && city.getBuildings().size() == 0) {
                cityRepository.deleteById(id);
                cityRepository.flush();
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public boolean save(City city) {
        try {
            cityRepository.save(city);
            cityRepository.flush();
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
