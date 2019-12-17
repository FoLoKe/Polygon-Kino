package polygon.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import polygon.models.Building;
import polygon.models.City;
import polygon.models.Performance;
import polygon.models.Session;
import polygon.repos.BuildingRepository;
import polygon.repos.SessionRepository;

import java.util.List;
import java.util.Map;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SessionServiceImplTest {

    @Autowired
    private SessionService sessionService;
    @MockBean
    private BuildingRepository buildingRepository;
    @MockBean
    private SessionRepository sessionRepository;
    @Test
    public void findSessionsInCity() {
        City city = new City();
        List<Session> expected=sessionService.findSessionsInCity(city);
        Assert.assertNotNull(expected);
        Assert.assertEquals(0,expected.size());
    }

    @Test
    public void findBuildingsWithSessionsInCity() {
        Performance performance = new Performance();
        City city = new City();
        java.util.Date utilDate = new java.util.Date(System.currentTimeMillis());
        java.sql.Timestamp time = new java.sql.Timestamp(utilDate.getTime());
        Map<Building, List<Session>> orderedTest = sessionService.findBuildingsWithSessionsInCity(performance,city,time);
        Assert.assertNotNull(orderedTest);
        Assert.assertEquals(0,orderedTest.size());
    }

    @Test
    public void findById() {
        Object object;
        object = sessionService.findById(1);
        Assert.assertNotNull(object);
    }
}