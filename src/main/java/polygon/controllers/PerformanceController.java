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

        if(city != null) {
            geoCity = city.getName();
        } else if (cities.size() > 0) {
            city = cities.get(0);
        } else {
            city = new City();
            city.setName("unknown");
            city.setId(-1);
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

    // TODO: debug scheduling doesn't check for time collisions
    @GetMapping(value = "/debug")
    public ModelAndView getPerformance() {
        Calendar ac = Calendar.getInstance();
        Timestamp time = new Timestamp(ac.getTimeInMillis());

        List<Performance> performances = performanceService.allPresentPerformances();
        List<Room> rooms = roomService.allRooms();
        List<Session> sessionsToAdd = new ArrayList<>();

        for(int day = 0; day < 2; day++) {

            ac.set(Calendar.MINUTE, 0);
            ac.set(Calendar.SECOND, 0);
            ac.set(Calendar.HOUR_OF_DAY, 6);

            for (int minute = 0; minute < 8; minute++) {
                time.setTime(ac.getTimeInMillis());

                for (Room room : rooms) {
                    for (Performance performance : performances) {
                        sessionsToAdd.add(generateSession(room, performance, time));
                    }
                }
                ac.add(Calendar.MINUTE, 130);
            }
            ac.add(Calendar.DATE, 1);
        }

        List<Performance> premiers = performanceService.allPremiers();

        for (Performance performance : premiers) {
            Timestamp begin = new Timestamp(performance.getDate().getTime());
            ac.setTime(begin);

            ac.set(Calendar.HOUR_OF_DAY, 6);
            ac.set(Calendar.MINUTE, 0);
            ac.set(Calendar.SECOND, 0);

            for (int minute = 0; minute < 8; minute++) {
                time = new Timestamp(ac.getTimeInMillis());

                for (Room room : rooms) {
                    sessionsToAdd.add(generateSession(room, performance, time));
                }

                ac.add(Calendar.MINUTE, 130);
            }
        }

        sessionService.addSessions(sessionsToAdd);

        User user = new User();
        user.setUsername("FoLoKe");
        user.setPassword("1");
        user.setRole("USER");
        user.setBalance(999); // TODO: Bonuses doesn't show up
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

    private static Session generateSession(Room room, Performance performance, Timestamp time) {
        Session session = new Session();
        session.setRoom(room);

        session.setTime(time);
        session.setPrice(250);

        Set<Ticket> tickets = new LinkedHashSet<>();

        for (SeatsRow sr : room.getSeatsRows()) {
            for (Seat seat : sr.getSeats()) {
                if (seat.isSeat()) {
                    Ticket ticket = new Ticket();
                    ticket.setOccupied(false);
                    ticket.setSeat(seat);
                    ticket.setSession(session);
                    tickets.add(ticket);
                }
            }
        }

        session.setTickets(tickets);
        session.setPerformance(performance);

        return session;
    }
}
