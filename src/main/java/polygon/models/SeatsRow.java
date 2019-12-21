package polygon.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "polygon.seatsRows")
public class SeatsRow {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "seatsRow")
    private int seatsRow;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "seatsRow_id")
    @org.hibernate.annotations.OrderBy(clause = "seat")
    private Set<Seat> seats;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Room room;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getSeatsRow() {
        return seatsRow;
    }

    public void setSeatsRow(int seatsRow) {
        this.seatsRow = seatsRow;
    }

    public int getId() {
        return id;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRow() {
        return seatsRow;
    }

    public void setRow(int row) {
        this.seatsRow = row;
    }
}
