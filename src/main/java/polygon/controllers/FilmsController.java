package polygon.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.Category;
import polygon.models.City;
import polygon.models.Performance;
import polygon.models.User;
import polygon.services.CategoryService;
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

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value="/films", method = RequestMethod.GET)
    public ModelAndView allcitiesfilms(HttpServletRequest request) {

        List<City> cities = new ArrayList<>();
        try {
            cities = cityService.allCities();
        } catch (Exception ste) {
            System.out.println("no connection");
        }


        List<Category> tags = new ArrayList<>();
        List<Performance> films = new ArrayList<>();
        try {
            films = performanceService.activePerformances();

        } catch (Exception e) {
            System.out.println("no connection");
        }

        try {
            tags = categoryService.allCategories();

        } catch (Exception e) {
            System.out.println("no connection");
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("films");
        modelAndView.addObject("filmsList", films);

        ModelAndView modelAndView2 = new ModelAndView();
        modelAndView2.setViewName("tags");
        modelAndView2.addObject("tagslist", tags);

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
