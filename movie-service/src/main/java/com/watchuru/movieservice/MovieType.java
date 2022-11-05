package com.watchuru.movieservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MovieType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String Desc;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return Desc;
	}

	public MovieType(int id, String desc) {
		super();
		this.id = id;
		Desc = desc;
	}

	public void setDesc(String desc) {
		Desc = desc;
	}
	
	public MovieType() {}


}
