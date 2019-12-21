package polygon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.*;
import polygon.services.BuildingService;
import polygon.services.CityService;
import polygon.services.PolygonUserDetailsService;
import polygon.services.SessionService;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
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

    @RequestMapping(value="/cinemas", method = RequestMethod.GET)
    public ModelAndView allcinemas(HttpServletRequest request,
                                   @CookieValue(value = "city", defaultValue = "1") int cityId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cinemas");

        List<City> cities;
        cities = cityService.allCities();
        modelAndView.addObject("citiesList", cities);

        String geoCity = "Москва";
        City city = cityService.findById(cityId);
        geoCity = city.getName();
        modelAndView.addObject("geoCity", geoCity);

        List<Building> cinemas;
        cinemas = buildingService.allByCity(city);
        modelAndView.addObject("cinemasList", cinemas);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userBalance = 0;
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        if(username != null && !username.isEmpty()) {
            User user = polygonUserDetailsService.getUserByUsername(username);
            if(user!= null) {
                userBalance = user.getBalance();
            }
        }
        modelAndView.addObject("userBalance", userBalance);

        return modelAndView;
    }

    @RequestMapping(value="/cinema", method = RequestMethod.GET)
    public ModelAndView cinemaDetails(@RequestParam("id") int id, HttpServletRequest request,
                                   @CookieValue(value = "city", defaultValue = "1") int cityId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cinemas");

        List<City> cities;
        cities = cityService.allCities();
        modelAndView.addObject("citiesList", cities);

        String geoCity = "Москва";
        City city = cityService.findById(cityId);
        geoCity = city.getName();
        modelAndView.addObject("geoCity", geoCity);

        Building cinema = buildingService.getById(id);
        modelAndView.addObject("cinema", cinema);

        Map<Timestamp, Map<Performance,List<Session>>> sessions = sessionService.findSessionsInBuilding(cinema);
        modelAndView.addObject("orderedPerformances", sessions);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userBalance = 0;
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        if(username != null && !username.isEmpty()) {
            User user = polygonUserDetailsService.getUserByUsername(username);
            if(user!= null) {
                userBalance = user.getBalance();
            }
        }
        modelAndView.addObject("userBalance", userBalance);

        return modelAndView;
    }
}
