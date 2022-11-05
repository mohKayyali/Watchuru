package com.watchuru.movieservice;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
	
	MovieRepo repo;
	
	public MovieController(MovieRepo repo)
	{this.repo=repo;}
	
	@GetMapping("/movie-service/movies")
	public List<Movie> getAllUsers(){
		return repo.findAll();
	}
	
	@GetMapping("/movie-service/movies/{id}")
	public Movie getById(@PathVariable int id){
		return repo.findById(id).get();
	}
	
	@PostMapping("/movie-service/movies")
	public Movie saveMovie(@RequestBody Movie movie){
		return repo.save(movie);
	}
	
	@PutMapping("/movie-service/movies")
	public Movie updateMovie(@RequestBody Movie movie){
		
		return repo.save(movie);
	}
	
	@GetMapping("/movie-service/movies/getcurrentprice/{id}")
	public float getCurrentPrice(@PathVariable int id){
		
		return repo.findById(id).get().getPrice();
	}

}
