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
}
