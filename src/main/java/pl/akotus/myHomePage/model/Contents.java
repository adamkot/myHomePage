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

    @Column(name="code")
    private String code;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Contents{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    public Contents(String text, String code) {
        this.text = text;
        this.code = code;
    }

    public Contents() {

    }
}
