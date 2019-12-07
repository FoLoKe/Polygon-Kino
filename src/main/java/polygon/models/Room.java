package polygon.models;

import org.hibernate.Hibernate;

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

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "session_id")
    private Set<Ticket> tickets;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id")
    private Building building;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<SeatsRow> getSeats() {
        return seatsRows;
    }

    public void setSeats(Set<SeatsRow> seats) {
        this.seatsRows = seats;
    }

    public Set<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Session> sessions) {
        this.sessions = sessions;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    @org.hibernate.annotations.OrderBy(clause = "seatsRow")
    private Set<SeatsRow> seatsRows;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private Set<Session> sessions;

    public void setId(int id) {
        this.id = id;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Set<SeatsRow> getSeatsRows() {
        return seatsRows;
    }

    public void setSeatsRows(Set<SeatsRow> seatsRows) {
        this.seatsRows = seatsRows;
    }
}
