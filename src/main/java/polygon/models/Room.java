package polygon.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "polygon.rooms")
public class Room {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type")
    private String type;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Set<Seat> seats;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Set<Session> sessions;
}
