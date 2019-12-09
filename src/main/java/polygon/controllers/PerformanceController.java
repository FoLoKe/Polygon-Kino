package polygon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.*;
import polygon.repos.CategoryRepository;
import polygon.repos.PerformanceRepository;
import polygon.services.CityService;
import polygon.services.PerformanceService;
import polygon.services.SessionService;

import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.*;

@Controller
public class PerformanceController {
    @Autowired
    private PerformanceService performanceService;

    @Autowired
    private CityService cityService;

    @Autowired
    private SessionService sessionService;

    @RequestMapping(value = "/performance", method = RequestMethod.GET)
    public ModelAndView getPerformance(@RequestParam("id") int id, @CookieValue(value = "city", defaultValue = "1") int cityId) {
        ModelAndView modelAndView = new ModelAndView();

        try {
            modelAndView.setViewName("performance");
            Performance performance = performanceService.findById(id);

            modelAndView.addObject("perf", performance);

            String geoCity = "Москва";
            try {
                City city = cityService.findById(cityId);
                geoCity = city.getName();
                Map<Building, List<Session>> buildingsMap = sessionService.findBuildingsWithSessionsInCity(performance, city);
                //buildingsMap =
                modelAndView.addObject("sessions_by_buildings", buildingsMap);

            } catch (Exception ste) {
                System.out.println("no connection");
            }

            modelAndView.addObject("geoCity", geoCity);

        } catch (NullPointerException e){
            System.out.println("no prop by id: " + id);
            modelAndView.setViewName("error");
        } catch (Exception e) {
            System.out.println("no connection");
            modelAndView.setViewName("error");
        }

        List<City> cities = new ArrayList<>();
        try {
            cities = cityService.allCities();
        } catch (Exception ste) {
            System.out.println("no connection");
        }



        modelAndView.addObject("citiesList", cities);
        return modelAndView;
    }

    @RequestMapping(value = "/img/{id}", method = RequestMethod.GET)
    public void getImage(@PathVariable("id") Integer id, HttpServletResponse response) {
        performanceService.writeImageToResponse(id, response);
    }

}
