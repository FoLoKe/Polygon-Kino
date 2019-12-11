package polygon.services;

import org.springframework.stereotype.Service;
import polygon.models.City;

import java.util.List;

public interface CityService {
    List<City> allCities();
    City findById(int id);
}
