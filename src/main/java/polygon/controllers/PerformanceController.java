package polygon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.Building;
import polygon.models.City;
import polygon.models.Performance;
import polygon.models.Session;
import polygon.services.CityService;
import polygon.services.PerformanceService;
import polygon.services.SessionService;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
}
