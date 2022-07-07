package polygon.controllers;

import org.apache.catalina.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.Building;
import polygon.models.City;
import polygon.models.Performance;
import polygon.models.Session;
import polygon.services.interfaces.BuildingService;
import polygon.services.interfaces.CityService;
import polygon.services.interfaces.SessionService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CinemasControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CinemasController controller;

    @MockBean
    private CityService cityService;

    @MockBean
    private BuildingService buildingService;

    @MockBean
    private SessionService sessionService;


    @Test
    public void allcinemas(){
        City city = new City();
        Building building = new Building();
        city.setId(1);
        building.setId(1);
        List<City> cities = List.of(city);
        List<Building> buildings = List.of(building);
        Set<Building> buildingsSet = Set.of(building);
        city.setBuildings(buildingsSet);

        Mockito.when(cityService.allCities()).thenReturn(cities);
        Mockito.when(cityService.findById(1)).thenReturn(city);
        Mockito.when(buildingService.allByCity(city)).thenReturn(buildings);

//        Authentication principal = Mockito.mock(Authentication.class);
//        principal.setAuthenticated(true);
//        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
//        Mockito.when(securityContext.getAuthentication()).thenReturn(principal);
//        SecurityContextHolder.setContext(securityContext);

        User applicationUser = Mockito.mock(User.class);
        Authentication authentication = Mockito.mock(Authentication.class);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        Mockito.when(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).thenReturn(applicationUser);

        ModelAndView expected = controller.allCinemas(1);

        Assert.assertNotNull(expected);
    }

    public void cinemasConnection() throws  Exception {
        this.mockMvc.perform(get("//cinemas"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void cinemaDetails() {
        City city = new City();
        Building building = new Building();
        city.setId(1);
        building.setId(1);
        List<City> cities = List.of(city);
        Set<Building> buildingsSet = Set.of(building);
        city.setBuildings(buildingsSet);
        Map<Performance, List<Session>> performances_sessions = Map.of();

        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        Mockito.when(cityService.allCities()).thenReturn(cities);
        Mockito.when(cityService.findById(1)).thenReturn(city);
        Mockito.when(buildingService.findById(1)).thenReturn(building);
        Mockito.when(sessionService.findSessionsInBuilding(building,timestamp)).thenReturn(performances_sessions);

        User applicationUser = Mockito.mock(User.class);
        Authentication authentication = Mockito.mock(Authentication.class);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
        Mockito.when(SecurityContextHolder.getContext().getAuthentication().getPrincipal()).thenReturn(applicationUser);

        ModelAndView expected = controller.cinemaDetails(1,1);

        Assert.assertNotNull(expected);
    }
}