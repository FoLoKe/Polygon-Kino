package polygon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.Room;
import polygon.models.Seat;
import polygon.models.SeatsRow;
import polygon.models.Session;
import polygon.services.RoomService;
import polygon.services.SessionService;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Controller
public class SelectionController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private SessionService sessionService;

    @RequestMapping(value = "/selectSeat", method = RequestMethod.GET)
    public ModelAndView getPerformance(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView();

        try {
            Session session = sessionService.findById(id);
            modelAndView.setViewName("selectSeat");
            Room room = roomService.findBySessions(session);
            Set<SeatsRow> rows = room.getSeatsRows();
            List<SeatsRow> rowsList = new LinkedList<>(rows);
            rowsList.sort(new Comparator<SeatsRow>() {
                @Override
                public int compare(SeatsRow o1, SeatsRow o2) {
                    return 0;
                }
            });


            modelAndView.addObject("room", room);

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return  modelAndView;
    }
}
