package pl.akotus.myHomePage.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor(access= AccessLevel.PUBLIC)
@NoArgsConstructor(access= AccessLevel.PUBLIC)
@Data
@Entity
@Table(name="contents")
public class Contents {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="text")
    private String text;

    @Column(name="code")
    private String code;

    @OneToOne
    @JoinColumn(name="image")
    private Attachment image;

    @Override
    public String toString() {
        return "Contents{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", code='" + code + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

}
