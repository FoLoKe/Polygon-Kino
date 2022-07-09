package polygon.services;

import com.stripe.Stripe;
import com.stripe.model.Charge;
import com.stripe.model.Refund;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import polygon.models.Ticket;
import polygon.models.TicketsTransaction;

import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    public StripeService(Environment environment) {
        Stripe.apiKey = environment.getProperty("STRIPE_API_KEY");
    }

    public Charge chargeNewCard(String token, double amount) throws Exception {
        Map<String, Object> chargeParams = new HashMap<>();
        chargeParams.put("amount", (int)(amount * 100));
        chargeParams.put("currency", "USD");
        chargeParams.put("source", token);

        return Charge.create(chargeParams);
    }

    public boolean refund(TicketsTransaction ticketsTransaction) {
        try {
            if (ticketsTransaction.isRefunded()
                    || ticketsTransaction.isByBalance()
                    || !ticketsTransaction.isEnded()) {
                return false;
            }

            Map<String, Object> params = new HashMap<>();
            int price = 0;

            for (Ticket ticket : ticketsTransaction.getTickets()) {
                price += ticket.getSession().getPrice();
            }

            params.put("charge", ticketsTransaction.getChargeId());
            params.put("amount", price);
            Refund refund = Refund.create(params);

            if (refund.getStatus().equals("succeeded")) {
                ticketsTransaction.setRefunded(true);

                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}