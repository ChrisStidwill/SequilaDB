package UIElements.primal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

// mvn spring-boot:run
// http://localhost:8080/home/getActor/199
// http://localhost:8080/home/allActors
// To self study postman: https://www.guru99.com/postman-tutorial.html
// Do what we did with actors with the other classes in the database
// Do joins in SQL
// you should have functionality that accesses intermediate tables (e.g. a method that returns all the actors in a given film)
// https://en.wikibooks.org/wiki/Java_Persistence/ManyToMany#Mapping_a_Join_Table_with_Additional_Columns (for joins)
// Cucumber tests - have at least one but try several.

@SpringBootApplication
@RestController
@RequestMapping("/home")
@CrossOrigin
public class PrimalApplication {
	@Autowired
	private ActorRepository actorRepository;
	private FilmRepository filmRepository;

	public PrimalApplication(ActorRepository ar, FilmRepository fr) {
		actorRepository = ar;
		filmRepository = fr;
	}

	public static void main(String[] args) {
		SpringApplication.run(PrimalApplication.class, args);
	}

	@GetMapping("/allActors")
	public @ResponseBody Iterable<Actor> getAllActors() {
		return actorRepository.findAll();
	}

	@GetMapping("/allFilms")
	public @ResponseBody Iterable<Film> getAllFilms(){return filmRepository.findAll();}

	@GetMapping("/getActor/{actor_id}")
	public @ResponseBody Actor getActorByID(@PathVariable("actor_id") int actorID) {
		return actorRepository.findById(actorID)
				 .orElseThrow(() -> new ResourceAccessException("ActorID doesn't exist in DB ; ; " + actorID));
//		return actor;
	}

	@GetMapping("/getFilm/{film_id}")
	public @ResponseBody Film getFilmByID(@PathVariable("film_id") int filmID) {
		return filmRepository.findById(filmID)
				.orElseThrow(() -> new ResourceAccessException("FilmID doesn't exist in DB ; ; " + filmID));
//		return film;
	}

	// Attempt to get all actors of a film
		// Access intermediate table - get all
		// Then return all actors with that ID.
	@GetMapping("/getActorsFromFilm/{film_id}")
	public @ResponseBody Iterable<Actor> getActorsByFilmID(@PathVariable("film_id") int filmID) {
		Film film = filmRepository.findById(filmID).orElseThrow(() -> new ResourceAccessException(
				"in PrimalApplication.java, getActorsByFilmID returned something other than Film"));
		return film.getActors();
	}

	@PostMapping("/allActors")
	public Actor newActor(@RequestBody Actor newActor) {
		return actorRepository.save(newActor);
	}

// Films need more attributes before this post will work.
//	@PostMapping("/allFilms")
//	public Film newFilm(@RequestBody Film newFilm){return filmRepository.save(newFilm);}

	// Changes - just went from 'get' to 'put' in path, and wrote ("actor_id") after @pathvariable.
	// check if something already exists. If not, don't update.
	@PutMapping("/putActor/{actor_id}")
	public Actor replaceActor(@RequestBody Actor newActor, @PathVariable("actor_id") int actorID) {
		return actorRepository.findById(actorID)
				.map(actor -> {
					actor.setFirstname(newActor.getFirstname());
					actor.setLastname(newActor.getLastname());
					return actorRepository.save(newActor);
				})
				.orElseGet(() -> {
					newActor.setActorid(actorID);
					return actorRepository.save(newActor);
				});
	}

//	@PutMapping("/putFilm/{film_id}")
//	public Film replaceFilm(@RequestBody Film newFilm, @PathVariable("film_id") int filmID) {
//		return filmRepository.findById(filmID)
//				.map(film -> {
//					film.setTitle(newFilm.getTitle());
//					film.setDescription(newFilm.getDescription());
//					film.setDuration(newFilm.getDuration());
//					return filmRepository.save(newFilm);
//				})
//				.orElseGet(() -> {
//					newFilm.setFilmid(filmID);
//					return filmRepository.save(newFilm);
//				});
//	}

	@DeleteMapping("/deleteActor/{actor_id}")
	public void deleteActor(@PathVariable("actor_id") int actorID){
		actorRepository.deleteById(actorID);
	}

	@DeleteMapping("/deleteFilm/{film_id}")
	public void deleteFilm(@PathVariable("film_id") int filmID) {filmRepository.deleteById(filmID);}

//
	// Get post put delete
}
