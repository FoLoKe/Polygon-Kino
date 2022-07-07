package polygon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.*;
import polygon.services.PolygonUserDetailsService;
import polygon.services.interfaces.*;

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

    @Autowired
    private PolygonUserDetailsService polygonUserDetailsService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/performance")
    public ModelAndView getPerformance(@RequestParam("id") int id,
                                       @RequestParam(value = "type", required = false, defaultValue = "") String type,
                                                   @CookieValue(value = "city", defaultValue = "1") int cityId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("performance");

        Date date = new Date(System.currentTimeMillis());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Timestamp time = new java.sql.Timestamp(date.getTime());
        modelAndView.addObject("day", dateFormat.format(date));

        Performance performance = performanceService.findByIdFullLoad(id);
        modelAndView.addObject("perf", performance);


        List<City> cities;
        cities = cityService.allCities();
        modelAndView.addObject("citiesList", cities);

        String geoCity="";
        City city = cityService.findById(cityId);
        if(city == null && cities.size() > 0) {
            city = (City) cities.toArray()[0];
        }

        if(city != null) {
            geoCity = city.getName();
        }

        modelAndView.addObject("geoCity", geoCity);

        Map<Timestamp, Map<Building, List<Session>>> schedule = performanceService.getSchedule(performance, city, type);
        modelAndView.addObject("schedule", schedule);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        User user = null;
        if(username != null && !username.isEmpty()) {
            user = polygonUserDetailsService.getUserByUsername(username);
            modelAndView.addObject("transactions", transactionService.findByUser(user));
        }
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @GetMapping(value = "/img/{id}")
    public void getImage(@PathVariable("id") Integer id, HttpServletResponse response) {
        performanceService.writeImageToResponse(id, response);
    }

    @GetMapping(value = "/preview/{id}")
    public void getPreviewImage(@PathVariable("id") Integer id, HttpServletResponse response) {
        performanceService.writePreviewToResponse(id, response);
    }

    @Autowired
    CategoryService categoryService;

    @Autowired
    RegService regService;

    @GetMapping(value = "/debug")
    public ModelAndView getPerformance() {

        java.util.Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        Timestamp time = new Timestamp(sqlDate.getTime());

        Calendar ac = Calendar.getInstance();
        ac.setTime(time);

        List<Performance> performances = performanceService.allPresentPerformances();
        List<Room> rooms = roomService.allRooms();
        for(int d = 0; d < 2; d++) {
            ac.add(Calendar.HOUR_OF_DAY, - time.getHours());
            ac.add(Calendar.MINUTE, - time.getMinutes());
            ac.add(Calendar.SECOND, - time.getSeconds());
            ac.add(Calendar.HOUR_OF_DAY, 6);

            for (int m = 0; m < 8; m++) {
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

        List<Performance> sPerformances = performanceService.allPremiers();
        for (Performance performance : sPerformances) {
            Timestamp begin = new Timestamp(performance.getDate().getTime());
            ac.setTime(begin);
            for(int d = 0; d < 1; d++) {
                ac.add(Calendar.HOUR_OF_DAY, -time.getHours());
                ac.add(Calendar.MINUTE, -time.getMinutes());
                ac.add(Calendar.SECOND, -time.getSeconds());
                ac.add(Calendar.HOUR_OF_DAY, 6);

                for (int m = 0; m < 1; m++) {
                    time = new Timestamp(ac.getTime().getTime());
                    for (Room room : rooms) {
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
                        s.setPerformance(performance);
                        sessionService.addSession(s);
                    }
                    ac.add(Calendar.MINUTE, 130);
                }

                ac.add(Calendar.DATE, 1);
            }

        }


        User user = new User();
        user.setUsername("FoLoKe");
        user.setPassword("1");
        user.setRole("USER");
        user.setBalance(999);
        user.setEmail("foloke@yandex.ru");
        regService.registerNewUserAccount(user);

        user = new User();
        user.setUsername("Admin");
        user.setPassword("1");
        user.setRole("ADMIN");
        user.setBalance(999);
        user.setEmail("tr12354@yandex.ru");
        regService.registerNewUserAccount(user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
