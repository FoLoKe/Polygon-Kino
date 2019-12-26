package polygon.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import polygon.models.City;
import polygon.services.interfaces.CityService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class CityServiceImplTest {

    @Autowired
    private CityService cityService;

    @Test
    public void allCities() {
        List<City> expected=cityService.allCities();
        Assert.assertNotNull(expected);
        Assert.assertEquals(2,expected.size());
    }

    @Test
    public void findById() {
        Object object;
        int id=1;
        object=cityService.findById(id);
        Assert.assertNotNull(object);
    }
}