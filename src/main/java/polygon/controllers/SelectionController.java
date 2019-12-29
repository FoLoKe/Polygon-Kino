package polygon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.*;
import polygon.services.EmailServiceImpl;
import polygon.services.PolygonUserDetailsService;
import polygon.services.interfaces.RoomService;
import polygon.services.interfaces.SessionService;
import polygon.services.interfaces.TicketService;
import polygon.services.interfaces.TransactionService;

import java.sql.Timestamp;
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

    @Autowired
    private EmailServiceImpl emailService;

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value = "/selectSeat", method = RequestMethod.GET)
    public ModelAndView getPerformance(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -1);
        Timestamp date = new Timestamp(calendar.getTime().getTime());
        Set<TicketsTransaction> ticketsTransactions = transactionService.findExpired(date);

        for(TicketsTransaction ticketsTransaction : ticketsTransactions) {
            ticketService.rollbackTickets(ticketsTransaction.getTickets());
            ticketsTransaction.setTerminated(true);
            transactionService.save(ticketsTransaction);
        }
        modelAndView.setViewName("selectSeat");

        Session session = sessionService.findById(id);

        Timestamp now = new Timestamp(new Date().getTime());
        if(session.getTime().before(now))
            return new ModelAndView("failPayment");

        modelAndView.addObject("ssession", session);

        int previewId = ((Preview) session.getPerformance().getPreviews().toArray()[0]).getId();
        modelAndView.addObject("imgId", previewId);

        Room room = roomService.findBySessions(session);
        Set<SeatsRow> rows = room.getSeatsRows();
        Set<Ticket> tickets = session.getTickets();

        String email = "";
        int balance = 0;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user;
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        if (username != null && !username.isEmpty() && !(username.equals("anonymousUser"))) {
            user = polygonUserDetailsService.getUserByUsername(username);
            email = user.getEmail();
            balance = user.getBalance();
        }

        modelAndView.addObject("email", email);
        modelAndView.addObject("balance", balance);
        List<Map<Seat, Ticket>> mapArrayList = new LinkedList<>();
        for (SeatsRow sr : rows) {
            Map<Seat, Ticket> map = new LinkedHashMap<>();
            for (Seat s : sr.getSeats()) {
                boolean found = false;
                for (Ticket t : tickets) {
                    if (t.getSeat().getId() == s.getId()) {
                        map.put(s, t);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    map.put(s, null);
                }

            }
            mapArrayList.add(map);
        }

        modelAndView.addObject("rowsList", mapArrayList);
        modelAndView.addObject("room", room);

        return modelAndView;
    }

    @RequestMapping(value = "/selectSeat", method = RequestMethod.POST)
    public ModelAndView reserveTickets(@RequestParam("ticketsId") String sids)
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
                        return new ModelAndView("redirect:/failPayment");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("bad link" + e.toString());
                    return new ModelAndView("redirect:/failPayment");
                }
            }
        }

        int transaction = ticketService.setTickets(ids);
        if(transaction != -1) {
            return new ModelAndView("redirect:/pay?id=" + transaction);
        }

        return new ModelAndView("failPayment");
    }

    @RequestMapping(value = "/confirmPage", method = RequestMethod.GET)
    public ModelAndView confirm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
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
