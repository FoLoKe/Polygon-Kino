package polygon.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import polygon.services.CityService;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private HomeController controller;

    @MockBean
    private CityService cityService;

//    @Test
//    public void allCities() throws Exception {
//        String geoCity = "Москва";
//        this.mockMvc.perform(get("/"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("КИНО УЖЕ СЕГОДНЯ")))
////                .andExpect(model().size(3))
//                .andExpect(model().attribute("geoCity",geoCity));
//
////        Mockito.verify(cityService,Mockito.times(1)).allCities();
//    }

    @Test
    public void RightAuthentificated() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(SecurityMockMvcResultMatchers.authenticated());

    }
}