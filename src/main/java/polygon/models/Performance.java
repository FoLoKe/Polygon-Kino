package polygon.models;

import javax.persistence.*;
import java.sql.Date;

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

    @Column(name = "date")
    private Date date;

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
