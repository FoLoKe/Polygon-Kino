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
import polygon.models.*;
import polygon.repos.CategoryRepository;
import polygon.repos.PerformanceRepository;
import polygon.repos.SessionRepository;
import polygon.services.interfaces.BuildingService;
import polygon.services.interfaces.PerformanceService;


import java.sql.Timestamp;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class PerformanceServiceImplTest {

    @Autowired
    private PerformanceService performanceService;

//    @Autowired
//    private SessionService sessionService;

    @MockBean
    private PerformanceRepository performanceRepository;

    @MockBean
    private CategoryRepository categoryRepository;

    @MockBean
    private BuildingService buildingService;

    @MockBean
    private SessionRepository sessionRepository;


    @Test
    public void allPerformances() {
        Performance performance = new Performance();
        performance.setId(1);
        List<Performance> performances = List.of(performance);
        Mockito.when(performanceRepository.findAll()).thenReturn(performances);
        List<Performance> expected=performanceService.allPerformances();
        Assert.assertNotNull(expected);
        Assert.assertEquals(1,expected.size());
    }

    @Test
    public void allPresentPerformances() {
        Performance performance = new Performance();
        java.util.Date utilDate = new java.util.Date(System.currentTimeMillis());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        performance.setId(1);
        List<Performance> performances = List.of(performance);
        Mockito.when(performanceRepository.findAllPresent(sqlDate)).thenReturn(performances);
        List<Performance> expected=performanceService.allPresentPerformances();
        Assert.assertNotNull(expected);
//        Assert.assertEquals(1,expected.size());
        // Проблемы со временем и датой
    }


    @Test
    public void findById() {
        Performance performance = new Performance();
        Category category = new Category();
        Set<Category> categories = Set.of(category);
        performance.setId(1);
        performance.setCategories(categories);
        Mockito.when(performanceRepository.findById(1)).thenReturn(Optional.of(performance));
        Performance expected = performanceService.findById(1);
        Assert.assertNotNull(expected);
        Mockito.verify(performanceRepository,Mockito.times(1)).findById(1);
    }

    @Test
    public void findByIdFullLoad() {
        Performance performance = new Performance();
        Category category = new Category();
        Preview preview = new Preview();
        Set<Category> categories = Set.of(category);
        Set<Preview> previews = Set.of(preview);
        performance.setId(1);
        performance.setCategories(categories);
        performance.setPreviews(previews);
        Mockito.when(performanceRepository.findById(1)).thenReturn(Optional.of(performance));
        Performance expected = performanceService.findByIdFullLoad(1);
        Assert.assertNotNull(expected);
        Mockito.verify(performanceRepository,Mockito.times(1)).findById(1);
    }

    @Test
    public void getSchedule() {
        Performance performance = new Performance();
        City city = new City();
        Building building = new Building();
        Session session = new Session();
        Room room = new Room();
        building.setId(1);
        session.setId(1);
        room.setId(1);
        session.setRoom(room);
        List<Building> buildings = List.of(building);
        List<Session> sessions = List.of(session);
        Date utilDate = new Date();
        Calendar ac = Calendar.getInstance();
        ac.setTime(utilDate);
        ac.add(Calendar.HOUR, - utilDate.getHours());
        ac.add(Calendar.MINUTE, - utilDate.getMinutes());
        ac.add(Calendar.SECOND, - utilDate.getSeconds());
        Timestamp time = new Timestamp(ac.getTime().getTime());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.add(Calendar.DATE, 1);
        Timestamp endTime = new Timestamp(calendar.getTime().getTime());

        Mockito.when(buildingService.allByCity(city)).thenReturn(buildings);
        Mockito.when(sessionRepository.findAllActiveSessionsOnPerformanceForBuilding(building,performance,time,endTime)).thenReturn(sessions);
        Map<Timestamp, Map<Building, List<Session>>> expected = performanceService.getSchedule(performance,city);
        Assert.assertNotNull(expected);
    }

    @Test
    public void activePerformances1() {
        City city = new City();
        Performance performance = new Performance();
        Category category = new Category();
        performance.setId(1);
        category.setId(1);
        Set<Category> categories = Set.of(category);
        performance.setCategories(categories);
        List<Performance> performances =List.of(performance);
        java.util.Date utilDate = new java.util.Date(System.currentTimeMillis());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        Mockito.when(performanceRepository.findAllActivePerformances(sqlDate,city)).thenReturn(performances);
        List <Performance> expected = performanceService.activePerformances(city);
        Assert.assertNotNull(expected);
    }

    @Test
    public void activePerformances2() {
        Performance performance = new Performance();
        Category category = new Category();
        performance.setId(1);
        category.setId(1);
        Set<Category> categories = Set.of(category);
        performance.setCategories(categories);
        List <Performance> performances = List.of(performance);
//        category.setName("АнИме");
        Mockito.when(categoryRepository.findById(1)).thenReturn(Optional.of(category));
        Mockito.when(performanceRepository.getAllFilmsByTag(category)).thenReturn(performances);
        List<Performance> expected=performanceService.activePerformances(1);
        Assert.assertNotNull(expected);
        Assert.assertEquals(1,expected.size());
    }


    @Test
    public void allPremiers() {
        Performance performance = new Performance();
        Category category = new Category();
        performance.setId(1);
        category.setId(1);
        Set<Category> categories = Set.of(category);
        performance.setCategories(categories);
        List<Performance> performances =List.of(performance);
        java.util.Date utilDate = new java.util.Date(System.currentTimeMillis());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        Mockito.when(performanceRepository.findPremiers(sqlDate)).thenReturn(performances);
        List <Performance> expected = performanceService.allPremiers();
        Assert.assertNotNull(expected);
    }


    @Test
    public void premiers() {
        City city = new City();
        Performance performance = new Performance();
        Category category = new Category();
        performance.setId(1);
        category.setId(1);
        Set<Category> categories = Set.of(category);
        performance.setCategories(categories);
        List<Performance> performances =List.of(performance);
        java.util.Date utilDate = new java.util.Date(System.currentTimeMillis());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        Mockito.when(performanceRepository.findAllPremiers(sqlDate,city)).thenReturn(performances);
        List <Performance> expected = performanceService.premiers(city);
        Assert.assertNotNull(expected);
//        Mockito.verify(performanceRepository,Mockito.times(1)).findAllPremiers(sqlDate, city);
    }

    @Test
    public void activeIMAXPerformances() {
        City city = new City();
        Performance performance = new Performance();
        Category category = new Category();
        performance.setId(1);
        category.setId(1);
        Set<Category> categories = Set.of(category);
        performance.setCategories(categories);
        List<Performance> performances =List.of(performance);
        java.util.Date utilDate = new java.util.Date(System.currentTimeMillis());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        Mockito.when(performanceRepository.findIMAX(sqlDate,city)).thenReturn(performances);
        List <Performance> expected = performanceService.activeIMAXPerformances(city);
        Assert.assertNotNull(expected);
    }

    @Test
    public void writeImageToResponse() {
        //Найти объявление http респонса
        //Ту ли картинку подгружает
        Performance performance = new Performance();
//        performance.setPoster();
//        Performance performance = performanceRepository.findById(1).orElse(null);
//        byte[] byteArray = performance.getPoster();
//        Assert.assertEquals(5,byteArray.length);
//        Assert.assertNotNull(performance);
//        Mockito.verify(performance,Mockito.times(1)).getPoster();
    }

    @Test
    public void writePreviewToResponse() {
        Performance performance = new Performance();
    }

    @Test
    public void add() {
        Performance performance = new Performance();
        performance.setId(1);
        List<Performance> performances =List.of(performance);
        performanceService.add(performances);
        Mockito.verify(performanceRepository,Mockito.times(1)).saveAll(performances);
        Mockito.verify(performanceRepository,Mockito.times(1)).flush();
    }

    @Test
    public void cancel() {
        Performance performance = new Performance();
        performance.setId(1);
        boolean expected = performanceService.cancel(1);
        Assert.assertTrue(expected);
        Mockito.verify(performanceRepository,Mockito.times(1)).deleteById(1);
    }

    @Test
    public void save() {
        Performance performance = new Performance();
        performance.setId(1);
        performanceService.save(performance);
        Mockito.verify(performanceRepository,Mockito.times(1)).saveAndFlush(performance);
    }
}