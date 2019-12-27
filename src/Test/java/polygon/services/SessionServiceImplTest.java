package polygon.services;

import org.junit.Assert;
import org.junit.Before;
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
import polygon.repos.PerformanceRepository;
import polygon.repos.SessionRepository;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

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
    private PerformanceRepository performanceRepository;

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
         Calendar c = Calendar.getInstance();
         c.setTime(time);
         c.add(Calendar.DATE, 1);
         Timestamp endTime = new Timestamp(c.getTime().getTime());
        Map<Building, List<Session>> orderedTest;
        orderedTest = sessionService.findBuildingsWithSessionsInCity(performance,city,time);
        Mockito.verify(buildingRepository,Mockito.times(1)).findByCity(city);
        Mockito.verify(sessionRepository,Mockito.times(0)).findAllActiveSessionsOnPerformanceForBuilding(b,performance,time,endTime);
        Assert.assertNotNull(orderedTest);
//        Assert.assertEquals(0,orderedTest.size());
    }

    @Test
    public void findSessionsInBuilding() {
        Building b = new Building();
        Calendar c = Calendar.getInstance();
        java.util.Date utilDate = new java.util.Date(System.currentTimeMillis());
        java.sql.Timestamp time = new java.sql.Timestamp(utilDate.getTime());
        Map<Performance, List<Session>> timestampMap;
        timestampMap = sessionService.findSessionsInBuilding(b,time);
        Assert.assertNotNull(timestampMap);
        Mockito.verify(performanceRepository,Mockito.times(1)).findAll();
    }

//    @Test
//    public void findById() {
//        Session session = new Session();
//        Object object;
//        int i = session.id();
//
//        SessionService serviceMock = mock(SessionService.class);
//        Mockito.when(serviceMock.findById(1)).thenReturn(session);
//        object = sessionService.findById(1);
//        Assert.assertNotNull(object);
//    }
}