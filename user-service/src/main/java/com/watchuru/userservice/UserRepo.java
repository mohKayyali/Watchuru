package com.watchuru.userservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	public User findByEmailIgnoreCaseAndPassword(String email,String password);

}
