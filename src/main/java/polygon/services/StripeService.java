package polygon.services;

import com.stripe.Stripe;
import com.stripe.model.Charge;
import com.stripe.model.Refund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import polygon.models.Ticket;
import polygon.models.TicketsTransaction;

import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    @Value("${STRIPE_SECRET_KEY}")
    private String API_SECRET_KEY;

    @Autowired
    public StripeService() {
        Stripe.apiKey = "sk_test_TbDlIGjayE65oNtis1r7RW9200NDcRyaUH";
    }

    public Charge chargeNewCard(String token, double amount) throws Exception {
        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("amount", (int)(amount * 100));
        chargeParams.put("currency", "USD");
        chargeParams.put("source", token);
        Charge charge = Charge.create(chargeParams);
        return charge;
    }

    public void refund(TicketsTransaction ticketsTransaction) {
        try {
            if (ticketsTransaction.isRefunded() || ticketsTransaction.isByBalance() || !ticketsTransaction.isEnded())
                return;


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
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}