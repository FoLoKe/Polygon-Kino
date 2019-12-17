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
import polygon.models.City;
import polygon.models.Performance;
import polygon.models.User;
import polygon.services.CityService;
import polygon.services.PerformanceService;
import polygon.services.PolygonUserDetailsService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FilmsController
{

    @Autowired
    private PolygonUserDetailsService polygonUserDetailsService;

    @Autowired
    private CityService cityService;

    @Autowired
    private PerformanceService performanceService;

    @RequestMapping(value="/films", method = RequestMethod.GET)
    public ModelAndView allFilmsInCity(HttpServletRequest request,
                                       @CookieValue(value = "city", defaultValue = "1") int cityId)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("films");

        List<City> cities;
        cities = cityService.allCities();
        modelAndView.addObject("citiesList", cities);

        String geoCity = "Москва";
        City city = cityService.findById(cityId);
        geoCity = city.getName();
        modelAndView.addObject("geoCity", geoCity);

        List<Performance> films;
        films = performanceService.activeIMAXPerformances(city);
        modelAndView.addObject("filmsList", films);

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

    @RequestMapping(value="/films", method = RequestMethod.POST)
    public ModelAndView filmsByTag(HttpServletRequest request, @RequestParam("tagsId") String sids,
                                       @CookieValue(value = "city", defaultValue = "1") int cityId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("films");

        String[] splitIds = sids.split(" ");
        List<Integer> ids = new ArrayList<>();
        for (String s: splitIds) {
            if(s!= null && !s.isEmpty()) {
                try {
                    ids.add(Integer.parseInt(s));

                } catch (NumberFormatException e) {
                    System.out.println("bad link" + e.toString());
                    return new ModelAndView("redirect:/confirmPage");
                }
            }
        }

        List<City> cities;
        cities = cityService.allCities();
        modelAndView.addObject("citiesList", cities);

        String geoCity = "Москва";
        City city = cityService.findById(cityId);
        geoCity = city.getName();
        modelAndView.addObject("geoCity", geoCity);

        List<Performance> films;
        films = performanceService.activeIMAXPerformances(city);
        modelAndView.addObject("filmsList", films);

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
