package polygon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.City;
import polygon.services.interfaces.CityService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/setCity")
    public ModelAndView setCity(@RequestParam("id") int id,
                                @RequestParam("source") String source,
                                HttpServletResponse response) {
        City city = cityService.findById(id);

        if(city != null) {
            Cookie cookie = new Cookie("city", Integer.toString(city.getId()));
            response.addCookie(cookie);
        }

        return new ModelAndView("redirect:" + source);
    }
}
