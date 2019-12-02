package polygon.models;

import javax.persistence.*;

@Entity
@Table(name = "polygon.categories")
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String string;

    public int getId() {
        return id;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
