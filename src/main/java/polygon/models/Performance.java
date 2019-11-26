package polygon.models;

import javax.persistence.*;

@Entity
@Table(name = "polygon.performances")
public class Performance {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "poster")
    private byte[] poster;
}
