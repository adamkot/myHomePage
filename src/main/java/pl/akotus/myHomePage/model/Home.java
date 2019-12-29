package pl.akotus.myHomePage.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor(access= AccessLevel.PUBLIC)
@NoArgsConstructor(access= AccessLevel.PUBLIC)
@Data
@Entity
@Table(name = "home")
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description", length = 12000)
    private String description;

    @Setter(AccessLevel.PUBLIC)
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "contents")
    private List<Contents> contents;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "enabled")
    private Boolean enabled;

    @Override
    public String toString() {
        return "Home{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", contents=" + contents +
                ", createDate=" + createDate +
                ", enabled=" + enabled +
                '}';
    }
}
