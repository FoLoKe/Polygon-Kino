package polygon.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.City;
import polygon.models.Performance;
import polygon.models.User;
import polygon.services.PolygonUserDetailsService;
import polygon.services.interfaces.CityService;
import polygon.services.interfaces.PerformanceService;
import polygon.services.interfaces.TransactionService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ImaxController {

    private final PolygonUserDetailsService polygonUserDetailsService;
    private final CityService cityService;
    private final PerformanceService performanceService;
    private final TransactionService transactionService;

    public ImaxController(PolygonUserDetailsService polygonUserDetailsService,
                          CityService cityService,
                          PerformanceService performanceService,
                          TransactionService transactionService) {
        this.polygonUserDetailsService = polygonUserDetailsService;
        this.cityService = cityService;
        this.performanceService = performanceService;
        this.transactionService = transactionService;
    }

    @GetMapping(value="/imax")
    public ModelAndView allIMAXFilms(HttpServletRequest request,
                                           @CookieValue(value = "city", defaultValue = "1") int cityId)
    {
        ModelAndView modelAndView = new ModelAndView("imax");

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

        List<Performance> films = performanceService.activeIMAXPerformances(city);
        modelAndView.addObject("filmsList", films);

        User user = polygonUserDetailsService.getUser();
        if(user != null) {
            modelAndView.addObject("transactions", transactionService.findByUser(user));
            modelAndView.addObject("user", user);
        }

        return modelAndView;
    }
}
