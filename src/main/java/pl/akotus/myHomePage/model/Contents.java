package pl.akotus.myHomePage.model;

import javax.persistence.*;

@Entity
@Table(name="page")
public class Contents {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="text")
    private String text;

    //attachment (image)


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Contents{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }

    public Contents(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public Contents() {

    }
}
