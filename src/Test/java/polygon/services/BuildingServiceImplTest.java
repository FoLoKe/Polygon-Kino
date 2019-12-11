package polygon.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import polygon.models.Building;
import polygon.repos.BuildingRepository;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class BuildingServiceImplTest {

    @MockBean
    private BuildingRepository buildingRepository;

    @Test
    public void allBuildings() {
        List<Building> expected=buildingRepository.findAll();
        Assert.assertNotNull(expected);
    }

    @Test
    public void add() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void edit() {
    }

    @Test
//    public void getById() {
//        Building building = new Building();
//        building = buildingRepository.getOne(1);
//        Assert.assertNotNull(building);
//    }
}
