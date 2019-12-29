package pl.akotus.myHomePage.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

@AllArgsConstructor(access= AccessLevel.PUBLIC)
@NoArgsConstructor(access= AccessLevel.PUBLIC)
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="password")
    @Length(min = 8, message = "*Twoje hasło musi się składać z minimum 8 znaków")
    private String password;

    @Column(name="name")
    @Length(min = 3, message = "*Podaj imię")
    private String name;

    @Column(name="last_name")
    @Length(min = 3, message = "*Podaj nazwisko")
    private String lastName;

    @Column(name="email")
    @Email(message = "*Podaj email")
    @Length(min = 3, message = "*Podaj email")
    private String email;

    // enabled - jeśli aktywny - usuwanie przez zmiane enabled na 0
    @Column(name="enabled")
    private Boolean enabled;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name="create_date")
    private Date createDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Column(name="last_activity_date")
    private Date lastActivityDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @Override
    public String toString() {
        return "User [id=" + id + ", password=" + password + ", name=" + name + ", lastName=" + lastName + ", email="
                + email + ", enabled=" + enabled + ", createDate=" + createDate
                + ", lastActivityDate=" + lastActivityDate + ", roles=" + roles
                + "]";
    }
    
}
