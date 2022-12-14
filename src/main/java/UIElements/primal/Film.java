package UIElements.primal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="film")

public class Film {

    public Film(){}

    public Film(String ttl, String desc, int length){
        title = ttl;
        description = desc;
        duration = length;
    }

    public int getFilmid() {
        return filmid;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration(){return duration;}

    //new stuff begins
    @ManyToMany //(targetEntity = Actor.class)
    @JoinTable(
            name = "film_actor",
            joinColumns = @JoinColumn(name="film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name="actor_id", referencedColumnName = "actor_id")
    )

    @JsonIgnore
    private List<Actor> actors;

    public List<Actor> getActors(){return actors;}

    //new stuff ends
    public void setFilmid(int filmid) {
        this.filmid = filmid;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String descr) {
        this.description = descr;
    }

    public void setDuration(int duration){
        this.duration = duration;
    }

    @Id
    @Column(name = "film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int filmid;

    @Column(name = "title")
    String title;

    @Column(name = "description")
    String description;

    @Column(name = "length")
    int duration;

}
