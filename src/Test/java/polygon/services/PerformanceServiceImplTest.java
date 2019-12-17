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
import polygon.models.Performance;
import polygon.repos.PerformanceRepository;

import java.awt.image.DataBufferByte;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class PerformanceServiceImplTest {

    @Autowired
    private PerformanceService performanceService;

//    @MockBean
//    PerformanceRepository performanceRepository;

    @Test
    public void allPerformances() {
        List<Performance> expected=performanceService.allPerformances();
        Assert.assertNotNull(expected);
        Assert.assertEquals(7,expected.size());
    }

    @Test
    public void findById() {
        Object object;
        object = performanceService.findById(1);
        Assert.assertNotNull(object);

    }

    @Test
    public void activePerformances() {
        List<Performance> expected=performanceService.activePerformances();
        Assert.assertNotNull(expected);
        Assert.assertEquals(5,expected.size());
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