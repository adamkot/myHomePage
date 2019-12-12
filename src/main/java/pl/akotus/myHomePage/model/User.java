package pl.akotus.myHomePage.model;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Date lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", password=" + password + ", name=" + name + ", lastName=" + lastName + ", email="
                + email + ", enabled=" + enabled + ", createDate=" + createDate
                + ", lastActivityDate=" + lastActivityDate + ", roles=" + roles
                + "]";
    }

    /*********************** Konstruktory ***********************/

    public User() {
        super();
    }

    public User(Integer id,
                @Length(min = 6, message = "*Twoje hasło musi się składać z minimum 6 znaków") String password,
                @Length(min = 3, message = "*Podaj imię") String name,
                @Length(min = 3, message = "*Podaj nazwisko") String lastName,
                @Email(message = "*Podaj email") String email, Boolean enabled, Date createDate,
                Date lastActivityDate, List<Role> roles) {
        super();
        this.id = id;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.enabled = enabled;
        this.createDate = createDate;
        this.lastActivityDate = lastActivityDate;
        this.roles = roles;
    }



}
