package com.watchuru.profileservice;




import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {
	
	private ProfileRepo repo;

	public ProfileController(ProfileRepo repo) {
		super();
		this.repo = repo;
	}
	
	
	@GetMapping("/profile-service/profiles/{id}")
	public Profile getById(@PathVariable int id) {
		
		Profile profile=repo.findById(id).get();
		
		return profile;
	}
	
	@GetMapping("/profile-service/profiles/type/{id}")
	public List<Profile> getByTypeId(@PathVariable int id) {
		
		ProfileType type=new ProfileType();
		
		type.setId(1);
		
		List<Profile>  profiles=repo.findByTypes(type);
		
	
		
		return  profiles;
		
	}
	
	

}
