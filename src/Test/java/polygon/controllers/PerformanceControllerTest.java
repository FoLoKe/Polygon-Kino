package polygon.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc


public class PerformanceControllerTest {

    @Autowired
    private MockMvc mockMvc;
    String performance;
    String geoCity;
    @Test
    public void connectionTest() throws Exception {
        this.mockMvc.perform(get("/performance?id=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("polygon.models.Performance@647d3279",performance))
                .andExpect(model().attribute("Москва",geoCity));


    }
}