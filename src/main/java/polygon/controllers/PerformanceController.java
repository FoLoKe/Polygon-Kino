package polygon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.Performance;
import polygon.repos.PerformanceRepository;

import java.util.Optional;

@Controller
public class PerformanceController {
    @Autowired
    private PerformanceRepository performanceRepository;

    @RequestMapping(value = "/performance", method = RequestMethod.GET)
    public ModelAndView getPerformance(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView();

        try {
            modelAndView.setViewName("performance");
            Optional<Performance> optional = performanceRepository.findById(id);
            if(optional.isPresent()) {
                modelAndView.addObject("perf", optional.get());
            }
            else {
                throw new NullPointerException();
            }
        } catch (NullPointerException e){
            System.out.println("no prop by id: " + id);
            modelAndView.setViewName("error");
        } catch (Exception e) {
            System.out.println("no connection");
            modelAndView.setViewName("error");
        }

        return modelAndView;
    }
}
