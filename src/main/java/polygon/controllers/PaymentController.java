package polygon.controllers;

import com.stripe.model.Card;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import polygon.models.Ticket;
import polygon.models.TicketsTransaction;
import polygon.models.User;
import polygon.services.EmailServiceImpl;
import polygon.services.PolygonUserDetailsService;
import polygon.services.StripeService;
import polygon.services.TransactionServiceImpl;
import polygon.services.interfaces.TicketService;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Controller
public class PaymentController {

    @Value("${STRIPE_PUBLIC_KEY}")
    private final String stripePublicKey;

    private final TicketService ticketService;
    private final EmailServiceImpl emailService;
    private final PolygonUserDetailsService polygonUserDetailsService;
    private final TransactionServiceImpl transactionService;
    private final StripeService stripeService;

    public PaymentController(
            TicketService ticketService,
            EmailServiceImpl emailService,
            PolygonUserDetailsService polygonUserDetailsService,
            TransactionServiceImpl transactionService,
            StripeService stripeService, Environment environment) {
        this.ticketService = ticketService;
        this.emailService = emailService;
        this.polygonUserDetailsService = polygonUserDetailsService;
        this.transactionService = transactionService;
        this.stripeService = stripeService;
        this.stripePublicKey = environment.getProperty("STRIPE_PUBLIC_KEY");
    }

    @RequestMapping("/pay")
    public String pay(@RequestParam("id") int id, Model model) {

        int balance = 0;
        String email = "";
        User user = polygonUserDetailsService.getUser();

        if(user != null) {
            balance = user.getBalance();
            email = user.getEmail();
        }

        int price = 0;
        TicketsTransaction ticketsTransaction = transactionService.findById(id);

        if (!ticketsTransaction.isEnded() && ticketsTransaction.isNotTerminated()) {
            Set<Ticket> tickets = ticketsTransaction.getTickets();

            for (Ticket ticket : tickets) {
                price += ticket.getSession().getPrice();
            }

            model.addAttribute("email", email);
            model.addAttribute("id", ticketsTransaction.getId());
            model.addAttribute("tickets", tickets);
            model.addAttribute("balance", balance);
            model.addAttribute("amount", price);
            model.addAttribute("stripePublicKey", stripePublicKey);

            return "pay";
        }

        return "failPayment";
    }

    @PostMapping(value = "/charge")
    public ModelAndView chargeCard(@RequestParam("id") int id, @RequestParam("byBalance") int byBalance, HttpServletRequest request) throws Exception {
        String token = request.getParameter("stripeToken");
        double amount = Double.parseDouble(request.getParameter("amount"));

        ModelAndView modelAndView = new ModelAndView("failPayment");

        User user = polygonUserDetailsService.getUser();
        int balance = 0;

        if(user != null) {
            balance = user.getBalance();
        }

        int price = 0;
        TicketsTransaction ticketsTransaction = transactionService.findById(id);

        if (!ticketsTransaction.isEnded()  && ticketsTransaction.isNotTerminated()) {
            for (Ticket ticket : ticketsTransaction.getTickets()) {
                price += ticket.getSession().getPrice();
            }

            if (byBalance == 1) {
                {
                    if (user != null && balance - price >= 0) {
                        user.setBalance(balance - price);
                        polygonUserDetailsService.saveUser(user);
                        List<Integer> ids = new LinkedList<>();
                        for (Ticket ticket : ticketsTransaction.getTickets()) {
                            ids.add(ticket.getId());
                        }
                        sendEmail(user.getEmail(), ids);
                        ticketsTransaction.setEnded(true);
                        ticketsTransaction.setEmail(user.getEmail());
                        ticketsTransaction.setTerminated(false);
                        ticketsTransaction.setRefunded(false);
                        ticketsTransaction.setByBalance(true);
                        transactionService.save(ticketsTransaction);
                        modelAndView.setViewName("successPayment");
                    }
                }
            } else {
                ////API оплаты
                Charge charge = stripeService.chargeNewCard(token, amount);
                if (charge.getStatus().equals("succeeded")) {
                    if (user != null) {
                        user.setBalance(user.getBalance() + price / 10);
                        polygonUserDetailsService.saveUser(user);
                    }

                    List<Integer> ids = new LinkedList<>();
                    for (Ticket ticket : ticketsTransaction.getTickets()) {
                        ids.add(ticket.getId());
                    }
                    sendEmail(((Card) charge.getSource()).getName(), ids);
                    ticketsTransaction.setEnded(true);
                    ticketsTransaction.setEmail(((Card) charge.getSource()).getName());
                    ticketsTransaction.setChargeId(charge.getId());
                    ticketsTransaction.setByBalance(false);
                    ticketsTransaction.setRefunded(false);
                    transactionService.save(ticketsTransaction);
                    modelAndView.setViewName("successPayment");
                }
            }
        }

        return modelAndView;
    }

    public void sendEmail(String email, List<Integer> ids) {
        Ticket first = ticketService.loadTicket(ids.get(0));
        StringBuilder emailText = new StringBuilder("Спасибо за покупку!" +
                "\n Ваши билеты на: " + first.getSession().getPerformance().getName() +
                "\n Зал №: " + first.getSeat().getSeatsRow().getRoom().getNumber() +
                "\n По адресу: " + first.getSeat().getSeatsRow().getRoom().getBuilding().getAddress());

        for (int id : ids) {
            Ticket ticket = ticketService.loadTicket(id);
            emailText.append("\n\nБилет №").append(ticket.getId()).append("\n Ряд: ").append(ticket.getSeat().getSeatsRow().getRow()).append("\n Место: ").append(ticket.getSeat().getSeat());

        }
        emailService.sendSimpleMessage(email, "Ваши билеты", emailText.toString());
    }

    @PostMapping(value = "/refund")
    public ModelAndView refund(@RequestParam("id") int id) {
        TicketsTransaction ticketsTransaction = transactionService.findById(id);

        if(ticketsTransaction.getUser() != null) {
            User user = polygonUserDetailsService.getUser();

            if (user != null) {
                if (ticketsTransaction.isEnded() && !ticketsTransaction.isRefunded() && ticketsTransaction.getUser().getId() == user.getId()) {
                    if(stripeService.refund(ticketsTransaction)) {
                        ticketService.rollbackTickets(ticketsTransaction.getTickets());
                        transactionService.save(ticketsTransaction);
                        emailService.sendSimpleMessage(ticketsTransaction.getEmail(), "Возврат билетов",
                                "С вашего аккаунта был оформлен возврат средств."
                        );
                    }
                }
            }
        }

        return new ModelAndView("redirect:/");
    }
}

