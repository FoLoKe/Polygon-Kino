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
import polygon.models.*;
import polygon.repos.BuildingRepository;
import polygon.repos.PerformanceRepository;
import polygon.repos.SessionRepository;
import polygon.services.interfaces.SessionService;

import java.sql.Timestamp;
import java.util.*;

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
    public void addSession() {
        Session session = new Session();
        sessionService.addSession(session);
        Mockito.verify(sessionRepository,Mockito.times(1)).save(session);
        Mockito.verify(sessionRepository,Mockito.times(1)).flush();
    }

     @Test
    public void findBuildingsWithSessionsInCity() {
        Performance performance = new Performance();
        City city = new City();
        Building building = new Building();
        Session session = new Session();
        building.setId(1);
        city.setId(1);
        building.setCity(city);
        List<Building> buildings = List.of(building);
        List<Session> sessions = List.of(session);
        java.util.Date utilDate = new java.util.Date(System.currentTimeMillis());
        java.sql.Timestamp time = new java.sql.Timestamp(utilDate.getTime());
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        c.add(Calendar.DATE, 1);
        Timestamp endTime = new Timestamp(c.getTime().getTime());

        Mockito.when(buildingRepository.findByCity(city)).thenReturn(buildings);
        Mockito.when(sessionRepository.findAllActiveSessionsOnPerformanceForBuilding(building, performance, time, endTime)).thenReturn(sessions);

        Map<Building, List<Session>> orderedTest = sessionService.findBuildingsWithSessionsInCity(performance,city,time);
        Mockito.verify(buildingRepository,Mockito.times(1)).findByCity(city);
        Mockito.verify(sessionRepository,Mockito.times(0)).findAllActiveSessionsOnPerformanceForBuilding(building,performance,time,endTime);
        Assert.assertNotNull(orderedTest);
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

    @Test
    public void findById() {
        Session session = new Session();
        Ticket ticket = new Ticket();
        Performance performance = new Performance();
        Preview preview = new Preview();
        session.setId(1);
        ticket.setId(1);
        performance.setId(1);
        Set<Ticket> tickets =Set.of(ticket);
        Set<Preview> previews =Set.of(preview);
        performance.setPreviews(previews);
        session.setPrice(250);
        session.setTickets(tickets);
        session.setPerformance(performance);
        Mockito.when(sessionRepository.findById(1)).thenReturn(Optional.of(session));
        Session expected = sessionService.findById(1);
        Assert.assertNotNull(expected);
    }

    @Test
    public void cancel() {
        Session session = new Session();
        Ticket ticket = new Ticket();
        Performance performance = new Performance();
        Preview preview = new Preview();
        session.setId(1);
        ticket.setId(1);
        performance.setId(1);
        Set<Ticket> tickets =Set.of(ticket);
        Set<Preview> previews =Set.of(preview);
        performance.setPreviews(previews);
        session.setPrice(250);
        session.setTickets(tickets);
        session.setPerformance(performance);
        Mockito.when(sessionRepository.findById(1)).thenReturn(Optional.of(session));
        sessionService.cancel(1);
        Mockito.verify(sessionRepository,Mockito.times(1)).flush();
    }
}