package polygon.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import polygon.models.Building;
import polygon.services.interfaces.BuildingService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class BuildingServiceImplTest {

    @Autowired
    private BuildingService buildingService;

    @Test
    public void allBuildings() {
        List<Building> expected=buildingService.allBuildings();
        Assert.assertNotNull(expected);
        Assert.assertEquals(5,expected.size());
    }


    @Test
    public void getById() {
        Object object;
        int id = 1;
        object=buildingService.getById(id);
        Assert.assertNotNull(object);

    }
}
