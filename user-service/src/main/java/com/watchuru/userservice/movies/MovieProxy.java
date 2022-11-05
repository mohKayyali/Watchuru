package com.watchuru.userservice.movies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="movie-service",url="localhost:8017")
public interface MovieProxy {
	
	@GetMapping("/movie-service/movies/getcurrentprice/{id}")
	public float getCurrentPrice(@PathVariable int id);
	
	

}
