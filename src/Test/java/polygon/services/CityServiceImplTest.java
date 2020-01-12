package polygon.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import polygon.models.Building;
import polygon.models.City;
import polygon.repos.CityRepository;
import polygon.services.interfaces.CityService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class CityServiceImplTest {

    @Autowired
    private CityService cityService;

    @MockBean
    private CityRepository cityRepository;

    @Test
    public void allCities() {
        City city = new City();
        Building building = new Building();
        city.setId(1);
        building.setId(1);
        Set<Building> buildings = Set.of(building);
        city.setBuildings(buildings);
        List <City> cities = List.of(city);
        Mockito.when(cityRepository.findAll()).thenReturn(cities);
        List<City> expected=cityService.allCities();
        Assert.assertNotNull(expected);
        Assert.assertEquals(1,expected.size());
    }

    @Test
    public void findById() {
        City city = new City();
        city.setId(1);
        Mockito.when(cityRepository.findById(1)).thenReturn(Optional.of(city));
        City expected=cityService.findById(1);
        Assert.assertNotNull(expected);
    }

    @Test
    public void safeDelete() {
        City city = new City();
        city.setId(1);
        boolean expected = cityService.safeDelete(1);
        Assert.assertTrue(expected);
        Mockito.verify(cityRepository,Mockito.times(1)).deleteById(1);
        Mockito.verify(cityRepository,Mockito.times(1)).flush();
    }

    @Test
    public void save() {
        City city = new City();
        city.setId(1);
        boolean expected = cityService.save(city);
        Assert.assertTrue(expected);
        Mockito.verify(cityRepository,Mockito.times(1)).save(city);
        Mockito.verify(cityRepository,Mockito.times(1)).flush();
    }
}