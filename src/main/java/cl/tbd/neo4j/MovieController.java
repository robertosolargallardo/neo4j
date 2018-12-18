package cl.tbd.neo4j;

import java.util.Collection;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MovieController {

	private final MovieService movieService;
	private final PersonService personService;
	
	public MovieController(MovieService movieService,PersonService personService) {
		this.movieService = movieService;
		this.personService = personService;
	}
	 @GetMapping("/acted")
		public Collection<Movie> acted(@RequestParam String name) {
			return movieService.acted(name);
		}
    @GetMapping("/graph")
	public Map<String, Object> graph(@RequestParam(value = "limit",required = false) Integer limit) {
		return movieService.graph(limit == null ? 100 : limit);
	}
    @GetMapping("/person")
    public Person findByName(@RequestParam String name) {
       return personService.findByName(name);
    }
    @GetMapping("/movie")
    public Movie findByTitle(@RequestParam String title) {
       return movieService.findByTitle(title);
    }
    @GetMapping("/movies")
    public Collection<Movie> findByTitleLike(@RequestParam String title) {
       return movieService.findByTitleLike(title);
    }
}