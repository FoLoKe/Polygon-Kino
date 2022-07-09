package polygon.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "polygon.ticketsTransactions")
public class TicketsTransaction {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ended")
    private boolean ended;

    @Column(name = "date")
    private Timestamp date;

    @Column(name = "terminated")
    private boolean terminated;

    @Column(name = "byBalance")
    private boolean byBalance;

    @Column(name = "refunded")
    private boolean refunded;

    @Column(name = "email")
    private String email;

    @Column(name = "charge_id")
    private String chargeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "transaction_id")
    private Set<Ticket> tickets;

    public boolean isByBalance() {
        return byBalance;
    }

    public void setByBalance(boolean byBalance) {
        this.byBalance = byBalance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isRefunded() {
        return refunded;
    }

    public void setRefunded(boolean refunded) {
        this.refunded = refunded;
    }

    public String getChargeId() {
        return chargeId;
    }

    public void setChargeId(String chargeId) {
        this.chargeId = chargeId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public boolean isNotTerminated() {
        return !terminated;
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }
}
