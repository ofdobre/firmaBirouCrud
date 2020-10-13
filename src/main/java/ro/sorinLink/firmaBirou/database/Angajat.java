package ro.sorinLink.firmaBirou.database;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;

@Entity
@Table(name = "angajat")
public class Angajat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user")
    User user;
    String cnp;
    String functie;
    String name;
    @Column(name = "lastname")
    String lastName;
    String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
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

    public String getEmail() { return email;}

    public void setEmail(String email) { this.email = email; }
}
