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
}
