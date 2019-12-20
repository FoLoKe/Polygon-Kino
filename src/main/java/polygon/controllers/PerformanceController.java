package polygon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.*;
import polygon.services.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
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

        Date date = new Date(System.currentTimeMillis());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Timestamp time = new java.sql.Timestamp(date.getTime());
        modelAndView.addObject("day", dateFormat.format(date));

        init(modelAndView, id, cityId, time);

        return modelAndView;
    }

    @RequestMapping(value = "/performance", method = RequestMethod.POST)
    public ModelAndView getPerformanceWithDate(@RequestParam("id") int id,
                                               @CookieValue(value = "city", defaultValue = "1") int cityId,
                                               @ModelAttribute("day") String date)
    {
        ModelAndView modelAndView = new ModelAndView();

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date utilDate = new Date();
        try {
            utilDate = dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Timestamp time = new java.sql.Timestamp(utilDate.getTime());
        modelAndView.addObject("day", date);

        init(modelAndView, id, cityId, time);

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

    private void init(ModelAndView modelAndView, int id, int cityId, Timestamp time) {
        modelAndView.setViewName("performance");

        Performance performance = performanceService.findById(id);
        modelAndView.addObject("perf", performance);

        String geoCity = "Москва";
        City city = cityService.findById(cityId);
        geoCity = city.getName();
        modelAndView.addObject("geoCity", geoCity);

        List<City> cities = new ArrayList<>();
        cities = cityService.allCities();
        modelAndView.addObject("citiesList", cities);

        Map<Building, List<Session>> buildingsMap = sessionService.findBuildingsWithSessionsInCity(performance, city, time);
        modelAndView.addObject("sessions_by_buildings", buildingsMap);
    }

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/debug", method = RequestMethod.GET)
    public ModelAndView getPerformance() {
        byte[] poster = performanceService.findById(2).getPoster();

//        Performance performance = new Performance();
        java.util.Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        Timestamp time = new Timestamp(sqlDate.getTime());

        Calendar ac = Calendar.getInstance();
        ac.setTime(time);
        ac.add(Calendar.HOUR, + 1);
        time = new Timestamp(ac.getTime().getTime());
////    ac.add(Calendar.MINUTE, - time.getMinutes());
////        performance.setPoster(poster);
////        performance.setDate(sqlDate);
////        performance.setName("debug film");
////        performance.setDescription("debug description");
////        performance.setCategories(new LinkedHashSet<>(categoryService.allCategories()));
////
////        List<Performance> performances = new ArrayList<>();
////        for(int i = 12; i<1000; i++) {
////            performance.setId(i);
////            performances.add(performance);
////        }w
////
////        performanceService.add(performances);
        List<Performance> performances = performanceService.allPresentPerformances();
        Room room = roomService.findById(1);
        for (Performance p : performances) {
            Session s = new Session();
            s.setTime(time);
            s.setPrice(250);

            s.setRoom(room);
            Set<Ticket> tickets = new LinkedHashSet<>();
            for(SeatsRow sr : room.getSeatsRows()) {
                for(Seat seat : sr.getSeats()) {
                    Ticket ticket = new Ticket();
                    ticket.setOccupied(false);
                    ticket.setSeat(seat);
                    ticket.setSession(s);
                    tickets.add(ticket);
                }
            }

            s.setTickets(tickets);
            s.setPerformance(p);
            sessionService.addSession(s);
//            for(Ticket t : tickets) {
//                ticketService.addTicket(t);
//            }
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
}
