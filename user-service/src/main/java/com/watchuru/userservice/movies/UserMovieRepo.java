package com.watchuru.userservice.movies;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMovieRepo extends JpaRepository<UserMovie, Integer>{

}
