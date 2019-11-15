package polygon.services;

import org.springframework.stereotype.Service;
import polygon.models.City;

import java.util.List;

@Service
public interface CityService {
    List<City> allCities();
    void add(City city);
    void delete(City city);
    void edit(City city);
    City getById(int id);
}
