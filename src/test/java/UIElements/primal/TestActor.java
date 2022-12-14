package UIElements.primal;
import UIElements.primal.Actor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestActor {
    @Test
    public void testActorParamConstructor(){
        Actor myTestActor = new Actor("Beevis","Jr");
        Assertions.assertEquals("Beevis", myTestActor.getFirstname(), "First names are not ==");
        Assertions.assertEquals("Jr", myTestActor.getLastname(), "Last names are not ==");
    }

    @Test public void testActorSetters(){
        Actor myTestActor = new Actor();
        myTestActor.setLastname("Agor");
        myTestActor.setActorid(2);
        myTestActor.setFirstname("Igor");
        Assertions.assertEquals("Agor", myTestActor.getLastname());
        Assertions.assertEquals("Igor", myTestActor.getFirstname());
        Assertions.assertEquals(2, myTestActor.getActorid());
        Assertions.assertNotEquals(3,myTestActor.getActorid());
        Assertions.assertNotEquals("Agor", myTestActor.getFirstname());
        Assertions.assertEquals(myTestActor.getFilms(),null);
        Assertions.assertEquals(myTestActor.getClass(), Actor.class);
    }
}