package UIElements.primal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

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

    @ManyToMany //(targetEntity = Actor.class)
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name="actor_id", referencedColumnName = "actor_id"),
            inverseJoinColumns = @JoinColumn(name="film_id", referencedColumnName = "film_id")
    )

    @JsonIgnore
    private List<Film> films;

    public List<Film> getFilms(){return films;}

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
