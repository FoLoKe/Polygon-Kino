package polygon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.*;
import polygon.services.PolygonUserDetailsService;
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

    @Autowired
    private PolygonUserDetailsService polygonUserDetailsService;

    @RequestMapping(value = "/selectSeat", method = RequestMethod.GET)
    public ModelAndView getPerformance(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("purchaseInfo", new PurchaseInfo());
        try {
            Session session = sessionService.findById(id);
            modelAndView.addObject("ssession", session);

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

    @RequestMapping(value = "/selectSeat", method = RequestMethod.POST)
    public ModelAndView getPerformance(@RequestParam("byBalance") int byBalance,
                                       @RequestParam("cats") String sids,
                                       @ModelAttribute("purchaseInfo") PurchaseInfo purchaseInfo,
                                       BindingResult result,
                                       Model model)
    {
        int price = 0;
        String[] splitIds = sids.split(" ");
        List<Integer> ids = new ArrayList<>();
        for (String s: splitIds) {
            if(s!= null && !s.isEmpty()) {
                try {
                    ids.add(Integer.parseInt(s));
                    Ticket ticket=ticketService.getTicketById(Integer.parseInt(s)) ;
                    if(ticket != null) {
                        price += ticket.getSession().getPrice();
                    } else {
                        return new ModelAndView("redirect:/confirmPage");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("bad link" + e.toString());
                    return new ModelAndView("redirect:/confirmPage");
                }
            }
        }

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = null;
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }

        if(username != null && !username.isEmpty()) {
           user = polygonUserDetailsService.getUserByUsername(username);
        }

            if(ticketService.setTickets(ids)) {
                if (byBalance == 1) {
                    {
                        if(user!= null && user.getBalance() - price >=0) {
                            user.setBalance(user.getBalance() - price);
                            polygonUserDetailsService.saveUser(user);
                        }
                        else {
                            ticketService.rollbackTickets(ids);
                        }
                    }
                } else {
                    ////API оплаты
                    if(user != null) {
                        user.setBalance(user.getBalance() + price / 10);
                        polygonUserDetailsService.saveUser(user);
                    }
                }
            } else {
                ticketService.rollbackTickets(ids);
            }

        return new ModelAndView("redirect:/confirmPage");
    }

    @RequestMapping(value = "/confirmPage", method = RequestMethod.GET)
    public ModelAndView confirm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("confirmPage");
        return modelAndView;
    }

    public class PurchaseInfo {
        public ArrayList<Integer> ids;
        public String tel;
        public String email;
        public boolean byBalance;

        public ArrayList<Integer> getIds() {
            return ids;
        }

        public void setIds(ArrayList<Integer> ids) {
            this.ids = ids;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public boolean isByBalance() {
            return byBalance;
        }

        public void setByBalance(boolean byBalance) {
            this.byBalance = byBalance;
        }
    }
}
