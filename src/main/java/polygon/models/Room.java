package polygon.models;

import javax.persistence.*;

@Entity
@Table(name = "polygon.rooms")
public class Room {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;



}
