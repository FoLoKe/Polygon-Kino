package polygon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.*;
import polygon.services.RoomService;
import polygon.services.SessionService;
import polygon.services.TicketService;

import java.util.*;

@Controller
public class SelectionController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private SessionService sessionService;

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/selectSeat", method = RequestMethod.GET)
    public ModelAndView getPerformance(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView();

        try {
            Session session = sessionService.findById(id);
            modelAndView.setViewName("selectSeat");
            Room room = roomService.findBySessions(session);
            Set<SeatsRow> rows = room.getSeatsRows();
            Set<Ticket> tickets = session.getTickets();

            List<Map<Seat, Ticket>> mapArrayList = new LinkedList<>();
            for (SeatsRow sr : rows) {
                Map<Seat, Ticket> map = new LinkedHashMap<>();
                for(Seat s : sr.getSeats()) {
                    for(Ticket t : tickets) {
                        if(t.getSeat().getId() == s.getId())
                            map.put(s, t);
                    }

                }
                mapArrayList.add(map);
            }

            modelAndView.addObject("rowsList",mapArrayList);
            modelAndView.addObject("room", room);

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return  modelAndView;
    }

    public class SeatWithState {
        public Seat seat;
        public Boolean state;
    }

    @RequestMapping(value = "/buy", method = RequestMethod.GET)
    public ModelAndView buyTickets(@RequestParam("ticketsId") String sids) {
        String[] splitIds = sids.split(" ");
        List<Integer> ids = new ArrayList<>();
        for (String s: splitIds) {
            if(s!= null && !s.isEmpty()) {
                try {
                    ids.add(Integer.parseInt(s));
                } catch (NumberFormatException e) {
                    System.out.println("bad link" + e.toString());
                }
            }
        }

        ticketService.setTickets(ids);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("confirmPage");

        return modelAndView;
    }
}
