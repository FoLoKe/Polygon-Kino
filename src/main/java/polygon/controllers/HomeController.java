package polygon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.City;
import polygon.models.Performance;
import polygon.models.User;
import polygon.services.EmailServiceImpl;
import polygon.services.PolygonUserDetailsService;
import polygon.services.interfaces.CityService;
import polygon.services.interfaces.PerformanceService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    EmailServiceImpl emailService;

    @Autowired
    private PolygonUserDetailsService polygonUserDetailsService;

    @Autowired
    private CityService cityService;

    @Autowired
    private PerformanceService performanceService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView allCities(HttpServletRequest request,
                                  @CookieValue(value = "city", defaultValue = "1") int cityId)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");

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

        List<Performance> films =  performanceService.activePerformances(city);
//        List<Performance> tempFilms = performanceService.activePerformances(city);
//        for (Performance film : tempFilms) {
//            films.add(film);
//            if(films.size() >= 5)
//                break;
//        }
        modelAndView.addObject("filmsList", films);

        List<Performance> premiers =  performanceService.allPremiers();
//        List<Performance> tempPremiers = performanceService.allPremiers();
//        for (Performance film : tempPremiers) {
//            premiers.add(film);
//            if(premiers.size() >= 5)
//                break;
//        }
        modelAndView.addObject("premiersList", premiers);

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int userBalance = 0;
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        User user = null;
        if(username != null && !username.isEmpty()) {
            user = polygonUserDetailsService.getUserByUsername(username);
        }
        modelAndView.addObject("user", user);

        return modelAndView;
    }
}