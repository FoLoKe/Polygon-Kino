package polygon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.*;
import polygon.services.PolygonUserDetailsService;
import polygon.services.interfaces.BuildingService;
import polygon.services.interfaces.CityService;
import polygon.services.interfaces.SessionService;
import polygon.services.interfaces.TransactionService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class CinemasController
{
    @Autowired
    private PolygonUserDetailsService polygonUserDetailsService;

    @Autowired
    private CityService cityService;

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping(value="/cinemas")
    public ModelAndView allCinemas(
            @CookieValue(value = "city", defaultValue = "1") int cityId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cinemas");

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
            List<Building> cinemasList = buildingService.allByCity(city);
            modelAndView.addObject("cinemasList", cinemasList);
        }


        modelAndView.addObject("geoCity", geoCity);

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

    @GetMapping(value="/cinema")
    public ModelAndView cinemaDetails(@RequestParam("id") int id,
                                   @CookieValue(value = "city", defaultValue = "1") int cityId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cinema");

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

        Building cinema = buildingService.findById(id);
        modelAndView.addObject("cinema", cinema);

        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());

        Map<Performance,List<Session>> sessions = sessionService.findSessionsInBuilding(cinema, timestamp);
        modelAndView.addObject("orderedPerformances", sessions);

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
}
