package com.watchuru.profileservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepo extends JpaRepository<Profile,Integer>{
	
	public List<Profile> findByTypes(ProfileType type);

}
