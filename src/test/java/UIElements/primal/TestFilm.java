package UIElements.primal;
import UIElements.primal.Film;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFilm {
    @Test
    public void testConstructor(){
        Film myTestFilm = new Film("StarWar", "War in the star", 50);
        myTestFilm.setTitle("WarStar");
        Assertions.assertEquals("WarStar", myTestFilm.getTitle(), "StarWar");
        Assertions.assertEquals("War in the star", myTestFilm.getDescription(), "War in the star");
        Assertions.assertNotEquals(49, myTestFilm.getDuration());
        Assertions.assertEquals(myTestFilm.getClass(),Film.class);
    }

    @Test public void testSetters(){
        Film newTestFilm = new Film();
        newTestFilm.setTitle("StarWar2");
        newTestFilm.setDescription("Another starwar film");
        newTestFilm.setDuration(11);
        newTestFilm.setFilmid(5);
        Assertions.assertEquals("StarWar2", newTestFilm.getTitle());
        Assertions.assertEquals("Another starwar film", newTestFilm.getDescription());
        Assertions.assertEquals(11, newTestFilm.getDuration());
        Assertions.assertEquals(5, newTestFilm.getFilmid());
    }
}