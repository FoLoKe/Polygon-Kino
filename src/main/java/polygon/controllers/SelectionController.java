package polygon.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.*;
import polygon.services.PolygonUserDetailsService;
import polygon.services.interfaces.RoomService;
import polygon.services.interfaces.SessionService;
import polygon.services.interfaces.TicketService;
import polygon.services.interfaces.TransactionService;

import java.sql.Timestamp;
import java.util.*;

@Controller
public class SelectionController {

    private final RoomService roomService;
    private final SessionService sessionService;
    private final TicketService ticketService;
    private final PolygonUserDetailsService polygonUserDetailsService;
    private final TransactionService transactionService;

    public SelectionController(RoomService roomService,
                               SessionService sessionService,
                               TicketService ticketService,
                               PolygonUserDetailsService polygonUserDetailsService,
                               TransactionService transactionService) {
        this.roomService = roomService;
        this.sessionService = sessionService;
        this.ticketService = ticketService;
        this.polygonUserDetailsService = polygonUserDetailsService;
        this.transactionService = transactionService;
    }

    @GetMapping(value = "/selectSeat")
    public ModelAndView getPerformance(@RequestParam("id") int id) {
        ModelAndView modelAndView = new ModelAndView("selectSeat");

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, -1);
        Timestamp date = new Timestamp(calendar.getTime().getTime());
        Set<TicketsTransaction> ticketsTransactions = transactionService.findExpired(date);

        for(TicketsTransaction ticketsTransaction : ticketsTransactions) {
            ticketService.rollbackTickets(ticketsTransaction.getTickets());
            ticketsTransaction.setTerminated(true);
            transactionService.save(ticketsTransaction);
        }

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

        User user = polygonUserDetailsService.getUser();

        if (user != null) {
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

    @PostMapping(value = "/selectSeat")
    public ModelAndView reserveTickets(@RequestParam("ticketsId") String sids)
    {
        String[] splitIds = sids.split(" ");
        List<Integer> ids = new ArrayList<>();

        for (String s: splitIds) {
            if(s!= null && !s.isEmpty()) {
                try {
                    ids.add(Integer.parseInt(s));
                    Ticket ticket=ticketService.getTicketById(Integer.parseInt(s));

                    if(ticket == null) {
                        return new ModelAndView("redirect:/failPayment");
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return new ModelAndView("redirect:/failPayment");
                }
            }
        }

        User user = polygonUserDetailsService.getUser(); // TODO: anonymous payment

        int transaction = ticketService.setTickets(ids, user);

        if(transaction != -1) {
            return new ModelAndView("redirect:/pay?id=" + transaction);
        }

        return new ModelAndView("failPayment");
    }

    @GetMapping(value = "/confirmPage")
    public ModelAndView confirm() {
        return new ModelAndView("redirect:/");
    }
}
