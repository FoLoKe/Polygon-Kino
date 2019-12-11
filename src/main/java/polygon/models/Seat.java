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

    @Column(name = "tickets")
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "seat_id")
    private Set<Ticket> tickets;

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
