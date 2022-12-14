package UIElements.primal;

import jakarta.persistence.*;

@Entity
@Table(name = "film_actor")

public class FilmActor {

    public FilmActor(){

    }

    public FilmActor(int aid, int fid){
        actorid = aid;
        filmid = fid;
    }

    public int getActorid() {
        return actorid;
    }

    public int getFilmid() {
        return filmid;
    }

    public void setActorid(int actorid) {
        this.actorid = actorid;
    }

    public void setFilmid(int filmid) {
        this.filmid = filmid;
    }

    @Id
    @Column(name = "actor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int actorid;

    @Column(name = "film_id")
    int filmid;
}