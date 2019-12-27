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
import polygon.models.City;
import polygon.models.Performance;
import polygon.repos.BuildingRepository;
import polygon.repos.CityRepository;
import polygon.repos.PerformanceRepository;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class PerformanceServiceImplTest {

    @Autowired
    private PerformanceService performanceService;

//    @MockBean
//    private CityRepository cityRepository;
//
//    @MockBean
//    private PerformanceRepository performanceRepository;

//    @Mock
//    City city = new City();

    @Test
    public void allPerformances() {
        List<Performance> expected=performanceService.allPerformances();
        Assert.assertNotNull(expected);
        Assert.assertEquals(20,expected.size());
    }

    @Test
    public void allPresentPerformances() {
        List<Performance> expected=performanceService.allPresentPerformances();
        Assert.assertNotNull(expected);
        Assert.assertEquals(10,expected.size());
    }


    @Test
    public void findById() {
        Object object;
        object = performanceService.findById(1);
        Assert.assertNotNull(object);
    }

    @Test
    public void activePerformances() {
        List<Performance> expected=performanceService.activePerformances(1);
        Assert.assertNotNull(expected);
        Assert.assertEquals(7,expected.size());
    }

//    @MockBean
//    private BuildingRepository buildingRepository;
//
//    @MockBean
//    private PerformanceRepository performanceRepository;

    @Test
    public void premiers() {
        City city = new City();
        Performance performance = new Performance();
        java.util.Date utilDate = new java.util.Date(System.currentTimeMillis());
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        List<Performance> expected=List.of(performance);
        PerformanceRepository serviceMock = mock(PerformanceRepository.class);
        Mockito.when(serviceMock.findAllPremiers(sqlDate,city)).thenReturn(expected);
        PerformanceServiceImpl performanceService = new PerformanceServiceImpl();
        expected=performanceService.premiers(city);
        Assert.assertNotNull(expected);
//        Mockito.verify(performanceRepository,Mockito.times(1)).findAllPremiers(sqlDate, city);
    }

    @Test
    public void writeImageToResponse() {
        Performance performance = new Performance();
//        performance.setPoster();
//        Performance performance = performanceRepository.findById(1).orElse(null);
//        byte[] byteArray = performance.getPoster();
//        Assert.assertEquals(5,byteArray.length);
//        Assert.assertNotNull(performance);
//        Mockito.verify(performance,Mockito.times(1)).getPoster();

    }
}