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

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }

    public Set<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Session> sessions) {
        this.sessions = sessions;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Set<Seat> seats;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Set<Session> sessions;
}
