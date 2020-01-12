package polygon.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.*;
import polygon.services.interfaces.PerformanceService;
import polygon.services.interfaces.RoomService;
import polygon.services.interfaces.SessionService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

    @Autowired
    private PerformanceController controller;

    @MockBean
    private RoomService roomService;

    @MockBean
    private PerformanceService performanceService;

    @MockBean
    private SessionService sessionService;


    @Test
    public void getPerformance(){
        Performance performance = new Performance();
        City city = new City();
        Building building = new Building();
        Session session = new Session();
        Room room = new Room();
        Category category = new Category();
        SeatsRow seatsRow = new SeatsRow();
        Seat seat = new Seat();
        Ticket ticket = new Ticket();
        room.setId(1);
        seatsRow.setId(1);
        seat.setId(1);
        ticket.setId(1);
        Set<SeatsRow> seatsRows = Set.of(seatsRow);
        Set<Seat> seats = Set.of(seat);
        Set<Ticket> tickets = Set.of(ticket);
        seat.setTickets(tickets);
        seatsRow.setSeats(seats);
        room.setSeatsRows(seatsRows);
        building.setId(1);
        session.setId(1);
        room.setId(1);
        category.setId(1);
        session.setRoom(room);
        Set<Category> categories = Set.of(category);
        performance.setCategories(categories);

        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);

        performance.setDate(date);
        List<Performance> performances = List.of(performance);
        List<Room> rooms = List.of(room);
        Mockito.when(performanceService.allPresentPerformances()).thenReturn(performances);
        Mockito.when(performanceService.findById(1)).thenReturn(performance);
        Mockito.when(roomService.allRooms()).thenReturn(rooms);
        Mockito.when(performanceService.allPremiers()).thenReturn(performances);
        ModelAndView expected = controller.getPerformance();
        Assert.assertNotNull(expected);
    }
}