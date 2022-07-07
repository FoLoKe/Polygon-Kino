package polygon.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.Category;
import polygon.models.City;
import polygon.models.Performance;
import polygon.models.User;
import polygon.services.PolygonUserDetailsService;
import polygon.services.interfaces.CategoryService;
import polygon.services.interfaces.CityService;
import polygon.services.interfaces.PerformanceService;
import polygon.services.interfaces.TransactionService;

import java.util.ArrayList;
import java.util.LinkedHashSet;
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

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TransactionService transactionService;


    @GetMapping(value = "/films")
    public ModelAndView filmsByTag(@RequestParam(required = false, name = "cats") String sids,
            @CookieValue(value = "city", defaultValue = "1") int cityId) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("films");

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

        List<Category> tags;
        tags = categoryService.allCategories();
        modelAndView.addObject("tagsList", tags);

        List<Performance> films = new ArrayList<>();
        Category selectedCategory = null;

        if(sids != null && !sids.isEmpty()) {
            String[] splitIds = sids.split(" ");
            LinkedHashSet<Integer> ids = new LinkedHashSet<>();
            for (String s : splitIds) {
                if (s != null && !s.isEmpty()) {
                    ids.add(Integer.parseInt(s));
                    films.addAll(performanceService.activePerformances(Integer.parseInt(s)));
                    selectedCategory = categoryService.findById(Integer.parseInt(s));
                }
            }
        } else {
            films = performanceService.activePerformances(city);
        }

        modelAndView.addObject("filmsList", films);

        modelAndView.addObject("selectedCategory", selectedCategory);

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
            modelAndView.addObject("transactions", transactionService.findByUser(user));
        }
        modelAndView.addObject("user", user);

        return modelAndView;
    }
}
