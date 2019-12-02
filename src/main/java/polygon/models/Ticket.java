package polygon.models;

import javax.persistence.*;

@Entity
@Table(name = "polygon.tickets")
public class Ticket {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "occupied")
    private boolean occupied;

    public int getId() {
        return id;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
