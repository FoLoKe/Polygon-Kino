package polygon.services;

import polygon.models.City;

import java.util.List;

public interface CityService {

    List<City> allCities();
    City findById(int id);
}
