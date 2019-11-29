package polygon.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "polygon.sessions")
public class Session {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "time")
    private Timestamp time;

    @Column(name = "price")
    private float price;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id")
    private Set<Ticket> tickets;



}
