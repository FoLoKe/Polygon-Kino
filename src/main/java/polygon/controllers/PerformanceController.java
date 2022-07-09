package polygon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

    private final PerformanceService performanceService;
    private final CityService cityService;
    private final SessionService sessionService;
    private final RoomService roomService;
    private final PolygonUserDetailsService polygonUserDetailsService;
    private final TransactionService transactionService;
    private final RegService regService;

    public PerformanceController(PerformanceService performanceService,
                                 CityService cityService,
                                 SessionService sessionService,
                                 RoomService roomService,
                                 PolygonUserDetailsService polygonUserDetailsService,
                                 TransactionService transactionService,
                                 RegService regService) {
        this.performanceService = performanceService;
        this.cityService = cityService;
        this.sessionService = sessionService;
        this.roomService = roomService;
        this.polygonUserDetailsService = polygonUserDetailsService;
        this.transactionService = transactionService;
        this.regService = regService;
    }

    @GetMapping(value = "/performance")
    public ModelAndView getPerformance(@RequestParam("id") int id,
                                       @RequestParam(value = "type", required = false, defaultValue = "") String type,
                                       @CookieValue(value = "city", defaultValue = "1") int cityId) {
        ModelAndView modelAndView = new ModelAndView("performance");

        Date date = new Date(System.currentTimeMillis());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
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

        User user = polygonUserDetailsService.getUser();

        if(user != null) {
            modelAndView.addObject("transactions", transactionService.findByUser(user));
            modelAndView.addObject("user", user);
        }

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
            ac.set(Calendar.HOUR_OF_DAY, 0);
            ac.set(Calendar.MINUTE, 0);
            ac.set(Calendar.SECOND, 0);
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
                ac.set(Calendar.HOUR_OF_DAY, 0);
                ac.set(Calendar.MINUTE, 0);
                ac.set(Calendar.SECOND, 0);
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

        return new ModelAndView("redirect:/");
    }
}
