package polygon.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.*;
import polygon.services.PolygonUserDetailsService;
import polygon.services.interfaces.*;

import java.sql.Timestamp;
import java.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ManagementControllerTest {



    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ManagementController controller;

    @Mock
    private CityService cityService;

    @Mock
    private CategoryService categoryService;

    @Mock
    private BuildingService buildingService;

    @Mock
    private SessionService sessionService;

    @Mock
    private RoomService roomService;

    @Mock
    private PerformanceService performanceService;

    @Mock
    private PolygonUserDetailsService userService;

    @Mock
    private TransactionService transactionService;

    @Test
    public void connectionManage() throws Exception {
        this.mockMvc.perform(get("/management/manageCities"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        this.mockMvc.perform(get("/management/manageCities/delete"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void mangeCities() {
        City city = new City();
        city.setId(1);
        List<City> cities = List.of(city);
        Mockito.when(cityService.allCities()).thenReturn(cities);
        ModelAndView expected = controller.manageCities();
        Assert.assertNotNull(expected);
    }

    @Test
    public void deleteCity() {
        City city = new City();
        city.setId(1);
        controller.deleteCity(1);
        Mockito.verify(cityService,Mockito.times(1)).safeDelete(1);
    }

    @Test
    public void manageCity() {
        City city = new City();
        city.setId(1);
        Mockito.when(cityService.findById(1)).thenReturn(city);
        ModelAndView expected = controller.manageCity(1);
        Assert.assertNotNull(expected);
    }

    @Test
    public void saveCity() {
        City city = new City();
        String s = "Город";
        city.setId(1);
        Mockito.when(cityService.findById(1)).thenReturn(city);
        ModelAndView expected = controller.saveCity(1,s);
        Mockito.verify(cityService,Mockito.times(1)).save(city);
    }

    @Test
    public void mangeCategories() {
        Category category = new Category();
        category.setId(1);
        List<Category> categories = List.of(category);
        Mockito.when(categoryService.allCategories()).thenReturn(categories);
        ModelAndView expected = controller.manageCategories();
        Assert.assertNotNull(expected);
    }

    @Test
    public void deleteCategory() {
        Category category = new Category();
        category.setId(1);
        controller.deleteCategory(1);
        Mockito.verify(categoryService,Mockito.times(1)).safeDelete(1);
    }

    @Test
    public void manageCategory() {
        Category category = new Category();
        category.setId(1);
        Mockito.when(categoryService.findById(1)).thenReturn(category);
        ModelAndView expected = controller.manageCategory(1);
        Assert.assertNotNull(expected);
    }

    @Test
    public void saveCategory() {
        Category category = new Category();
        category.setId(1);
        String s = "Категория";
        Mockito.when(categoryService.findById(1)).thenReturn(category);
        ModelAndView expected = controller.saveCategory(1,s);
        Mockito.verify(categoryService,Mockito.times(1)).save(category);
    }

    @Test
    public void manageBuildings() {
        Building building = new Building();
        building.setId(1);
        List<Building> buildings = List.of(building);
        Mockito.when(buildingService.allBuildings()).thenReturn(buildings);
        ModelAndView expected = controller.manageBuildings();
        Assert.assertNotNull(expected);
    }

    @Test
    public void deleteBuilding() {
        Building building = new Building();
        building.setId(1);
        controller.deleteBuilding(1);
        Mockito.verify(buildingService,Mockito.times(1)).safeDelete(1);
    }

    @Test
    public void manageBuilding1() {
        Building building = new Building();
        building.setId(1);
        List<Building> buildings = List.of(building);
        Mockito.when(buildingService.allBuildings()).thenReturn(buildings);
        Mockito.when(buildingService.findById(1)).thenReturn(building);
        ModelAndView expected = controller.manageBuilding(1);
        Assert.assertNotNull(expected);
    }

    @Test
    public void ManageBuilding2() {
        City city = new City();
        Building building = new Building();
        city.setId(1);
        building.setId(1);
        Mockito.when(buildingService.findById(1)).thenReturn(building);
        ModelAndView expected = controller.manageBuilding(1,"адрес","тип",1);
        Assert.assertNotNull(expected);
    }

    @Test
    public void mangeSessions() {
        City city = new City();
        Building building = new Building();
        city.setId(1);
        building.setId(1);
        List<Building> buildings = List.of(building);
        Set<Building> buildingsSet = Set.of(building);
        city.setBuildings(buildingsSet);
        Map<Performance, List<Session>> performances_sessions = Map.of();

        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        Mockito.when(buildingService.allBuildings()).thenReturn(buildings);
        Mockito.when(sessionService.findSessionsInBuilding(building,timestamp)).thenReturn(performances_sessions);

        ModelAndView expected = controller.manageSessions(0,"0");
        Assert.assertNotNull(expected);
    }

    @Test
    public void manageSessionByDay() {
        City city = new City();
        Building building = new Building();
        String s1 = "01.01.2020";
        String s2 = "1";
        city.setId(1);
        building.setId(1);
        List<Building> buildings = List.of(building);
        Set<Building> buildingsSet = Set.of(building);
        city.setBuildings(buildingsSet);
        Map<Performance, List<Session>> performances_sessions = Map.of();

        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        Mockito.when(buildingService.allBuildings()).thenReturn(buildings);
        Mockito.when(buildingService.findById(1)).thenReturn(building);
        Mockito.when(sessionService.findSessionsInBuilding(building,timestamp)).thenReturn(performances_sessions);

        ModelAndView expected = controller.manageSessionByDay(s1,s2);
        Assert.assertNotNull(expected);
    }

    @Test
    public void deleteSession() {
        Session session = new Session();
        session.setId(1);
        controller.deleteSession(1);
        Mockito.verify(sessionService,Mockito.times(1)).cancel(1);
    }

    @Test
    public void manageSession() {
        Session session = new Session();
        Performance performance = new Performance();
        Room room = new Room();
        session.setId(1);
        performance.setId(1);
        room.setId(1);
        List<Performance> performances = List.of(performance);
        List<Room> rooms = List.of(room);

        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        session.setPrice(1000);
        session.setTime(timestamp);

        Mockito.when(sessionService.findById(1)).thenReturn(session);
        Mockito.when(performanceService.allPerformances()).thenReturn(performances);
        Mockito.when(roomService.allRooms()).thenReturn(rooms);

        ModelAndView expected = controller.manageSession(1);
        Assert.assertNotNull(expected);
    }

    @Test
    public void saveSession() {
        Session session = new Session();
        Performance performance = new Performance();
        Room room = new Room();
        session.setId(1);
        performance.setId(1);
        room.setId(1);

        Mockito.when(sessionService.findById(1)).thenReturn(session);
        Mockito.when(roomService.findById(1)).thenReturn(room);
        Mockito.when(performanceService.findById(1)).thenReturn(performance);
        controller.saveSession(1,1000,1,1,"2017-03-08T12:30");
        Mockito.verify(sessionService,Mockito.times(1)).addSession(session);
    }

    @Test
    public void managePerformances() {
        Performance performance = new Performance();
        performance.setId(1);
        List<Performance> performances = List.of(performance);
        Mockito.when(performanceService.allPerformances()).thenReturn(performances);
        ModelAndView expected = controller.managePerformances();
        Assert.assertNotNull(expected);
    }

    @Test
    public void deletePerformance() {
        Performance performance = new Performance();
        performance.setId(1);
        controller.deletePerformance(1);
        Mockito.verify(performanceService,Mockito.times(1)).cancel(1);
    }

    @Test
    public void managePerformance() {
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        Performance performance = new Performance();
        Category category = new Category();
        category.setId(1);
        Set<Category> categories = Set.of(category);
        performance.setId(1);
        performance.setCategories(categories);
        performance.setName("Name");
        performance.setTrailerLink("Link");
        performance.setImdbRating("12/10");
        performance.setDescription("Description");
        performance.setDate(date);
        Mockito.when(performanceService.findById(1)).thenReturn(performance);
        Mockito.when(categoryService.findById(1)).thenReturn(category);
        ModelAndView expected = controller.managePerformance(1);
        Assert.assertNotNull(expected);
    }

    @Test
    public void savePerformance() {
        //тоже проблемы с датой
    }

    @Test
    public void mangeRooms() {
        Room room = new Room();
        room.setId(1);
        List<Room> rooms = List.of(room);
        Mockito.when(roomService.allRooms()).thenReturn(rooms);
        ModelAndView expected = controller.manageRooms();
        Assert.assertNotNull(expected);
    }

    @Test
    public void deleteRoom() {
        Room room = new Room();
        room.setId(1);
        controller.deleteRoom(1);
        Mockito.verify(roomService,Mockito.times(1)).safeDelete(1);
    }

    @Test
    public void manageRoom() {
        Building building = new Building();
        building.setId(1);
        List<Building> buildings = List.of(building);
        Mockito.when(buildingService.allBuildings()).thenReturn(buildings);
        ModelAndView expected = controller.manageRoom();
        Assert.assertNotNull(expected);
    }

    @Test
    public void saveRoom() {
        Room room = new Room();
        Building building = new Building();
        SeatsRow seatsRow = new SeatsRow();
        building.setId(1);
        seatsRow.setId(1);
        List<Integer> seatsCountList=new ArrayList<>();
        seatsCountList.add(1);
        List<String> seats=new ArrayList<>();
        seats.add("seat");
        Set<SeatsRow> seatsRows = Set.of(seatsRow);

        room.setNumber(1);
        room.setSeatsRows(seatsRows);

        Mockito.when(buildingService.findById(1)).thenReturn(building);
        controller.saveRoom(1,1,1,"type",seatsCountList,seats);
        Mockito.verify(roomService,Mockito.times(0)).save(room);
    }

    @Test
    public void mangeUsers() {
        User user = new User();
        user.setId(1);
        List<User> users = List.of(user);
        Mockito.when(userService.allUsers()).thenReturn(users);
        ModelAndView expected = controller.manageUsers();
        Assert.assertNotNull(expected);
    }

    @Test
    public void deleteUser() {
        User user = new User();
        user.setId(1);
        controller.deleteUser(1);
        Mockito.verify(userService,Mockito.times(1)).delete(1);
    }

    @Test
    public void manageUser() {
        User user = new User();
        user.setId(1);
        user.setPassword("password");
        user.setUsername("username");
        user.setEmail("email");
        user.setRole("Role");
        Mockito.when(userService.findById(1)).thenReturn(user);
        ModelAndView expected = controller.manageUser(1);
        Assert.assertNotNull(expected);
    }

    @Test
    public void saveUser() {
        User user = new User();
        Mockito.when(userService.findById(1)).thenReturn(user);
        controller.saveUser(1,"username","email","password",100,"Role");
        Mockito.verify(userService,Mockito.times(1)).save(user);
    }

    @Test
    public void mangeTransactions() {
        TicketsTransaction ticketsTransaction = new TicketsTransaction();
        ticketsTransaction.setId(1);
        List<TicketsTransaction> ticketsTransactions = List.of(ticketsTransaction);
        Mockito.when(transactionService.allTransactions()).thenReturn(ticketsTransactions);
        ModelAndView expected = controller.manageTransactions();
        Assert.assertNotNull(expected);
    }
}