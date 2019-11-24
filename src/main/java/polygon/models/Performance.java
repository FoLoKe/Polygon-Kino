package polygon.models;

import javax.persistence.*;

@Entity
@Table(name = "polygon.performances")
public class Performance {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
