package polygon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import polygon.model.City;
import polygon.service.ICityService;

import java.util.List;

@Controller
public class CityController {

    @Autowired
    private ICityService cityService;

    @GetMapping("/home")
    public String findCities(Model model) {

        model.addAttribute("cities", (List<City>) cityService.findAll());

        return "showCities";
    }
}