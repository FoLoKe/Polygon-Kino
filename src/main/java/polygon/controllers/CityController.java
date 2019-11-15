package polygon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.City;
import polygon.services.CityService;
import polygon.services.CityServiceImpl;

import java.util.List;


@Controller
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView allCities() {
        List<City> films = cityService.allCities();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        modelAndView.addObject("citiesList", films);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteCity(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        City film = cityService.getById(id);
        cityService.delete(film);
        return modelAndView;
    }
}