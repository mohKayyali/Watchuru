package com.watchuru.userservice;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.watchuru.userservice.movies.UserMovie;

import org.springframework.beans.factory.annotation.Autowired;



@Entity(name="user_details")
public class User {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@Autowired
	@OneToMany()
    @JoinTable(joinColumns=@JoinColumn(name="user_id"))

	private List<UserType> types;
	private String email;
	

	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	
	private List<UserMovie> purchasedMovies;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<UserType> getTypes() {
		return types;
	}
	public void setTypes(List<UserType> types) {
		this.types = types;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User() { 
	}
	
	public User(int id, String name, List<UserType> types, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.types = types;
		this.email = email;
		this.password = password;
	}
	public List<UserMovie> getPurchasedMovie() {
		return purchasedMovies;
	}
	public void setPurchasedMovie(List<UserMovie> purchasedMovieIds) {
		this.purchasedMovies = purchasedMovieIds;
	}
	
	

}
