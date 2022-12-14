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

public class ShowSingleFilmStepDef {
    @Autowired
    FilmRepository filmRepo;
    int filmID;
    Film film;

    @Given("a film exists in the db with ID {int}")
    public void a_film_exists_with_id(int ID){
        filmID = ID;
    }

    @When("I request that film's details")
    public void film_details_requested(){
        film = filmRepo.findById(filmID)
                .orElseThrow(() -> new ResourceAccessException("FilmID doesn't exist in DB ; ; " + filmID));
        // assertion statement to check if actor was retrieved
    }

    @Then("The webpage should show the film's {string}, {string}, and {string}")
    public void The_webpage_should_show_the_films_details(String title, String descr, String duration){
        String correctDetails = title + " " + descr + " " + duration;
        String testDetails = "";
        testDetails += film.getTitle() + " " + film.getDescription() + " " + Integer.toString(film.getDuration());
        Assertions.assertEquals(correctDetails, testDetails,
                "Incorrect details in film title, description, or duration.");
    }
}
