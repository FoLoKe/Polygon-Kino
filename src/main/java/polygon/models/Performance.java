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

    @Column(name = "description", length = 1024)
    private String description;

    @Column(name = "poster", length = 1024*1024)
    private byte[] poster;

    @Column(name = "date")
    private Date date;

    @Column(name = "categories")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "polygon.categories_performances")
    @OrderBy(value= "id")
    private Set<Category> categories;

    @Column(name = "previews")
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "polygon.previews_performances")
    @OrderBy(value= "id")
    private Set<Preview> previews;

    @Column(name = "sessions")
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_id")
    private Set<Session> sessions;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Preview> getPreviews() {
        return previews;
    }

    public void setPreviews(Set<Preview> previews) {
        this.previews = previews;
    }

    public Set<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Set<Session> sessions) {
        this.sessions = sessions;
    }

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
