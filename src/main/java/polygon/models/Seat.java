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

    @Column(name = "row")
    private int row;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id")
    private Ticket ticket;

    public int getId() {
        return id;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
