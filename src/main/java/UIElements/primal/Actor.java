package UIElements.primal;

import jakarta.persistence.*;

@Entity
@Table(name = "actor")

public class Actor {

    public Actor(){

    }

    public Actor(String fn, String ln){
        lastname = ln;
        firstname = fn;
    }

    public int getActorid() {
        return actorid;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setActorid(int actorid) {
        this.actorid = actorid;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Id
    @Column(name = "actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int actorid;

    @Column(name = "first_name")
    String firstname;

    @Column(name = "last_name")
    String lastname;

}
