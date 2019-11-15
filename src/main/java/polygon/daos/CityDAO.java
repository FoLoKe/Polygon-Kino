package polygon.daos;

import java.util.List;

import org.springframework.stereotype.Repository;
import polygon.models.City;

@Repository
public interface CityDAO {
    List<City> allCities();
    void add(City city);
    void delete(City city);
    void edit(City city);
    City getByID(int id);
}
