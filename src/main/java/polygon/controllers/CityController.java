package polygon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.City;
import polygon.services.CityService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/setCity")
    public ModelAndView setCity(@RequestParam("id") int id, HttpServletResponse response) {
        City city = cityService.findById(id);

        if(city != null){
            Cookie cookie = new Cookie("city", Integer.toString(city.getId()));
            response.addCookie(cookie);
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:");
        return modelAndView;
    }
}
