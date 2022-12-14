package UIElements.primal;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.ScenarioScope;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.ResourceAccessException;

@ScenarioScope

public class ShowSingleActorStepDef {
    @Autowired
    ActorRepository actorRepo;
    int actorID;
    Actor actor;

    @Given("an actor exists in the db with ID {int}")
    public void an_actor_exists_with_id(int ID){
        actorID = ID;
    }

    @When("I request that actor's details")
    public void actor_details_requested(){
        actor = actorRepo.findById(actorID)
                .orElseThrow(() -> new ResourceAccessException("ActorID doesn't exist in DB ; ; " + actorID));
        // assertion statement to check if actor was retrieved
    }

    @Then("The webpage should show the actors {string} and {string}")
    public void The_webpage_should_show_the_actors_firstname_and_lastname(String first, String last){
        String correctDetails = first + " " + last;
        String testDetails = "";
        testDetails += actor.getFirstname() + " " + actor.getLastname();
        Assertions.assertEquals(correctDetails, testDetails, "Incorrect details in actor (first & last name)");
    }
}
