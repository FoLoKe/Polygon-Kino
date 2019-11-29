package polygon.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

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

    @Column(name = "categories")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "polygon.categories_performances")
    private Set<Category> categories;

    @Column(name = "categories")
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_id")
    private Set<Session> sessions;

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
