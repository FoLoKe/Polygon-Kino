package polygon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.Building;
import polygon.models.City;
import polygon.models.Performance;
import polygon.models.User;
import polygon.services.BuildingService;
import polygon.services.CityService;
import polygon.services.PerformanceService;
import polygon.services.PolygonUserDetailsService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CinemasController
{
    @Autowired
    private PolygonUserDetailsService polygonUserDetailsService;



    @Autowired
    private BuildingService cityService;



    @RequestMapping(value="/cinemas", method = RequestMethod.GET)
    public ModelAndView allcinemas(HttpServletRequest request) {

        List<Building> cinemas = new ArrayList<>();
        try {
            cinemas = cityService.allBuildings();

        } catch (Exception e) {
            System.out.println("no connection");
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cinemas");

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
}
