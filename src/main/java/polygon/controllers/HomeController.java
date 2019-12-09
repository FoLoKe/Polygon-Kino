package polygon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.City;
import polygon.models.Performance;
import polygon.services.CityService;
import polygon.services.PerformanceService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {
    @Autowired
    private CityService cityService;
    @Autowired
    private PerformanceService performanceService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView allCities(HttpServletRequest request, @CookieValue(value = "city", defaultValue = "1") int cityId) {

        List<City> cities = new ArrayList<>();
        try {
            cities = cityService.allCities();
        } catch (Exception ste) {
            System.out.println("no connection");
        }

        String geoCity = "Москва";
        try {
            City city = cityService.findById(cityId);
            geoCity = city.getName();
        } catch (Exception ste) {
            System.out.println("no connection");
        }

        List<Performance> films = new ArrayList<>();
        try {
            films = performanceService.activePerformances();
        } catch (Exception e) {
            System.out.println("no connection");
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("geoCity", geoCity);
        modelAndView.addObject("filmsList", films);
        modelAndView.addObject("citiesList", cities);
        return modelAndView;
    }
}