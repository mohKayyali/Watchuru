package com.watchuru.profileservice;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Profile {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	private String Details;
	
	@ManyToMany
	private List<ProfileType> types;
	
	private String image;

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

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}

	public List<ProfileType> getTypes() {
		return types;
	}

	public void setType(List<ProfileType> type) {
		this.types = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public Profile() {}
	

}
