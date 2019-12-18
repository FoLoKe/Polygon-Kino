package polygon.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
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

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
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
    @MockBean
    City city;
    @Test
    public void findSessionsInCity() {
        City city = new City();
        sessionService.findSessionsInCity(city);
        Mockito.verify(sessionRepository,Mockito.times(1)).findAllActiveSessionForCity(city);
    }

     @Test
    public void findBuildingsWithSessionsInCity() {
        Performance performance = new Performance();
        City city = new City();
        Building b = new Building();
         java.util.Date utilDate = new java.util.Date(System.currentTimeMillis());
         java.sql.Timestamp time = new java.sql.Timestamp(utilDate.getTime());
        Map<Building, List<Session>> orderedTest = new LinkedHashMap<>();
        sessionService.findBuildingsWithSessionsInCity(performance,city,time);
        Mockito.verify(buildingRepository,Mockito.times(1)).findByCity(city);
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