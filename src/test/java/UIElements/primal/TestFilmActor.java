package UIElements.primal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class TestFilmActor {
    @Test
    public void TestFilmActorNoParamConstructor(){
        FilmActor filmActor = new FilmActor();
        filmActor.setActorid(5);
        filmActor.setFilmid(10);
        Assertions.assertEquals(filmActor.getActorid(),5,"filmactor actor id not correct");
        Assertions.assertEquals(filmActor.getFilmid(),10,"filmactor film id not correct");
        Assertions.assertNotEquals(filmActor.getActorid(),10);
    }

    @Test
    public void TestFilmActorParamConstructor(){
        FilmActor filmActor = new FilmActor(5,10);
        Assertions.assertEquals(filmActor.getActorid(),5,"filmactor actor id not correct");
        Assertions.assertEquals(filmActor.getFilmid(),10,"filmactor film id not correct");
        Assertions.assertNotEquals(filmActor.getActorid(),10);
    }
}
