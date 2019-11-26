package polygon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.daos.CityRepository;
import polygon.models.City;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;


    @Override
    @Transactional
    public List<City> allCities() {
        return cityRepository.findAll();
    }

    @Override
    @Transactional
    public void add(City city) {

    }

    @Override
    @Transactional
    public void delete(City city) {
        cityRepository.delete(city);
    }

    @Override
    @Transactional
    public void edit(City city) {

    }

    @Override
    @Transactional
    public City findById(int id) {
        return cityRepository.findById(id).orElse(null);
    }
}
