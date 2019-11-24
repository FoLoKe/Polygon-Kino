package polygon.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "polygon.buildings")
public class Building {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id")
    private Set<Room> buildings;


}
