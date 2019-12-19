package pl.akotus.myHomePage.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "contents")
    private List<Contents> contents;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "enabled")
    private Boolean enabled;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public List<Contents> getContents() {
        return contents;
    }

    public void setContents(List<Contents> contents) {
        this.contents = contents;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

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
