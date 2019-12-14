package pl.akotus.myHomePage.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="home")
public class Home {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="text", length = 40000)
    private String text;



    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name="create_date")
    private Date createDate;
}
