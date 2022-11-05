package com.watchuru.userservice.movies;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.watchuru.userservice.User;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class UserMovie {
	@Id
	@GeneratedValue
	private int id;
	
	private int movieId;
	private float price;
	
	public UserMovie() {}
	
	
	@Autowired
	@ManyToOne(cascade = CascadeType.ALL)
	private User buyer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public User getBuyer() {
		return buyer;
	}
	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}



}
