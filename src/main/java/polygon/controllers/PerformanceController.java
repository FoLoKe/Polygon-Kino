package polygon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.*;
import polygon.services.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class PerformanceController {

    @Autowired
    private PerformanceService performanceService;

    @Autowired
    private CityService cityService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/performance", method = RequestMethod.GET)
    public ModelAndView getPerformance(@RequestParam("id") int id, @CookieValue(value = "city", defaultValue = "1") int cityId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("performance");

        Date date = new Date(System.currentTimeMillis());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Timestamp time = new java.sql.Timestamp(date.getTime());
        modelAndView.addObject("day", dateFormat.format(date));

        Performance performance = performanceService.findByIdFullLoad(id);
        modelAndView.addObject("perf", performance);

        String geoCity;
        City city = cityService.findById(cityId);
        geoCity = city.getName();
        modelAndView.addObject("geoCity", geoCity);

        Map<Timestamp, Map<Building, List<Session>>> schedule = performanceService.getSchedule(performance, city);
        modelAndView.addObject("schedule", schedule);

        List<City> cities;
        cities = cityService.allCities();
        modelAndView.addObject("citiesList", cities);

        return modelAndView;
    }

    @RequestMapping(value = "/img/{id}", method = RequestMethod.GET)
    public void getImage(@PathVariable("id") Integer id, HttpServletResponse response) {
        performanceService.writeImageToResponse(id, response);
    }

    @RequestMapping(value = "/preview/{id}", method = RequestMethod.GET)
    public void getPreviewImage(@PathVariable("id") Integer id, HttpServletResponse response) {
        performanceService.writePreviewToResponse(id, response);
    }

    @Autowired
    CategoryService categoryService;

    @Autowired
    RegService regService;

    @RequestMapping(value = "/debug", method = RequestMethod.GET)
    public ModelAndView getPerformance() {

        java.util.Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        Timestamp time = new Timestamp(sqlDate.getTime());

        Calendar ac = Calendar.getInstance();
        ac.setTime(time);

        List<Performance> performances = performanceService.allPresentPerformances();
        List<Room> rooms = roomService.allCities();
        for(int d = 0; d < 2; d++) {
            ac.add(Calendar.HOUR, - time.getHours());
            ac.add(Calendar.MINUTE, - time.getMinutes());
            ac.add(Calendar.SECOND, - time.getSeconds());
            ac.add(Calendar.HOUR, 6);

            for (int m = 0; m < 5; m++) {
                time = new Timestamp(ac.getTime().getTime());
                for (Room room : rooms) {
                    for (Performance p : performances) {
                        Session s = new Session();
                        s.setTime(time);
                        s.setPrice(250);

                        s.setRoom(room);
                        Set<Ticket> tickets = new LinkedHashSet<>();
                        for (SeatsRow sr : room.getSeatsRows()) {
                            for (Seat seat : sr.getSeats()) {
                                if (seat.isSeat()) {
                                    Ticket ticket = new Ticket();
                                    ticket.setOccupied(false);
                                    ticket.setSeat(seat);
                                    ticket.setSession(s);
                                    tickets.add(ticket);
                                }
                            }
                        }

                        s.setTickets(tickets);
                        s.setPerformance(p);
                        sessionService.addSession(s);
                    }
                }
                ac.add(Calendar.MINUTE, 130);
            }
            ac.add(Calendar.DATE, 1);
        }

        User user = new User();
        user.setUsername("FoLoKe");
        user.setPassword("1");
        user.setBalance(999);
        user.setEmail("foloke@yandex.ru");
        regService.registerNewUserAccount(user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
