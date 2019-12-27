package polygon.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import polygon.services.interfaces.BuildingService;
import polygon.services.interfaces.CityService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CinemasControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CityService cityService;

    @Mock
    private BuildingService buildingService;

    @Test
    public void allcinemas() throws  Exception{
        this.mockMvc.perform(get("//cinemas"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void cinemaDetails() {
    }
}