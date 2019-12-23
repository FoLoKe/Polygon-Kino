package polygon.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "polygon.seats")
public class Seat {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "seat")
    private int seat;

    @Column
    private boolean isSeat;

    @Column(name = "tickets")
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id")
    private Set<Ticket> tickets;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seatsrow_id")
    private SeatsRow seatsRow;

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSeat() {
        return isSeat;
    }

    public void setSeat(boolean seat) {
        isSeat = seat;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public SeatsRow getSeatsRow() {
        return seatsRow;
    }

    public void setSeatsRow(SeatsRow seatsRow) {
        this.seatsRow = seatsRow;
    }

    public int getId() {
        return id;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

}
