package com.watchuru.userservice;

import java.util.ArrayList;
import java.util.List;

import com.watchuru.userservice.movies.MovieProxy;
import com.watchuru.userservice.movies.UserMovie;
import com.watchuru.userservice.movies.UserMovieRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	MovieProxy proxy;

	private UserRepo repo;
	private UserMovieRepo userMovieRepo;
	
	public UserController(UserRepo repo,UserMovieRepo userMovieRepo) {
		
		this.repo=repo;
		this.userMovieRepo=userMovieRepo;
		
	}
	
	@GetMapping("/user-service/users")
	public List<User> getAllUsers(){
		return repo.findAll();
	}
	
	@GetMapping("/user-service/users/{id}")
	public User getUserById(@PathVariable int id){
		return repo.findById(id).get();
	}
	
	
	@GetMapping("/user-service/users/login/email/{email}/password/{password}")
	public User login(@PathVariable String email,@PathVariable String password) {
		
		User user=repo.findByEmailIgnoreCaseAndPassword(email, password);
		
		return user;
		
	}
	
	@PostMapping("/user-service/users/register")
	public User register(@RequestBody User user ) {

		repo.save(user);
		
		return user;
	}
	
	@PutMapping("/user-service/users/")
	public User updateMovie(@RequestBody User user){
		
		return repo.save(user);
	}
	
	@PutMapping("/user-service/users/buymovie")
	public boolean buyMovie(@RequestBody int movieId){
		

		float price =proxy.getCurrentPrice(movieId);
		
		User user = repo.findById(1).get();
		UserMovie userMovie=new UserMovie();
		userMovie.setBuyer(user);
		userMovie.setPrice(price);
		userMovie.setMovieId(movieId);
		UserMovie saved=userMovieRepo.save(userMovie);
		List<UserMovie> list=new ArrayList<>();
		list.add(saved);
		user.setPurchasedMovie(list);
		
		repo.save(user);
		
		
		return true;

	}

}
