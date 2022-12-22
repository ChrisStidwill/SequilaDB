package UIElements.primal;
import UIElements.primal.Film;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFilm {
    @Test
    public void testConstructor(){
        Film myTestFilm = new Film("StarWar", "War in the star", 50);
        Assertions.assertEquals("StarWar", myTestFilm.getTitle(), "StarWar");
        Assertions.assertEquals("War in the star", myTestFilm.getDescription(), "War in the star");
        Assertions.assertNotEquals(49, myTestFilm.getDuration());
    }
}