package polygon.services;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.models.City;
import polygon.repos.CityRepository;
import polygon.services.interfaces.CityService;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    @Transactional
    @Cacheable
    public List<City> allCities() {
        return cityRepository.findAll();
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
            City city = findById(id);
            if(city != null && city.getBuildings().size() == 0) {
                cityRepository.deleteById(id);
                cityRepository.flush();
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
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
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
