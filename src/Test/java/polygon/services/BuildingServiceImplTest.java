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
import polygon.repos.BuildingRepository;
import polygon.services.interfaces.BuildingService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class BuildingServiceImplTest {

    @Autowired
    private BuildingService buildingService;

    @MockBean
    private BuildingRepository buildingRepository;

    @Test
    public void allBuildings() {
        Building building = new Building();
        City city = new City();
        building.setId(1);
        city.setId(1);
        building.setCity(city);
        List <Building> buildings = List.of(building);
        Mockito.when(buildingRepository.findAll()).thenReturn(buildings);
        List<Building> expected=buildingService.allBuildings();
        Assert.assertNotNull(expected);
        Assert.assertEquals(1,expected.size());
    }

    @Test
    public void allByCity() {
        City city = new City();
        Building building = new Building();
        city.setId(1);
        building.setId(1);
        Set<Building> buildingsSet = Set.of(building);
        city.setBuildings(buildingsSet);
        List <Building> buildingsList = List.of(building);
        Mockito.when(buildingRepository.findByCity(city)).thenReturn(buildingsList);
        List<Building> expected=buildingService.allByCity(city);
        Assert.assertNotNull(expected);
        Assert.assertEquals(1,expected.size());
    }


    @Test
    public void getById() {
        Building building = new Building();
        building.setId(1);
        Mockito.when(buildingRepository.findById(1)).thenReturn(Optional.of(building));
        Building expected=buildingService.findById(1);
        Assert.assertNotNull(expected);
        Mockito.verify(buildingRepository,Mockito.times(1)).findById(1);
    }

    @Test
    public void save() {
        Building building = new Building();
        building.setId(1);
        buildingService.save(building);
        Mockito.verify(buildingRepository,Mockito.times(1)).saveAndFlush(building);
    }

    @Test
    public void safeDelete() {
        buildingService.safeDelete(1);
        Mockito.verify(buildingRepository,Mockito.times(1)).deleteById(1);
    }

}
