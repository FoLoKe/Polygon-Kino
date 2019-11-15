package polygon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import polygon.daos.CityDAO;
import polygon.models.City;

import javax.sql.DataSource;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDAO cityDAO;


    @Override
    @Transactional
    public List<City> allCities() {
        return cityDAO.allCities();
    }

    @Override
    @Transactional
    public void add(City city) {
        cityDAO.add(city);
    }

    @Override
    @Transactional
    public void delete(City city) {
        cityDAO.delete(city);
    }

    @Override
    @Transactional
    public void edit(City city) {
        cityDAO.edit(city);
    }

    @Override
    @Transactional
    public City getById(int id) {
        return cityDAO.getByID(id);
    }
}
