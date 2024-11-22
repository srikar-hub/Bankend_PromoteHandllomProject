package com.klu.BackendHandlooms.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.klu.BackendHandlooms.Model.User;
import com.klu.BackendHandlooms.Model.UserPriniciple;
import com.klu.BackendHandlooms.Repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	    User user = userRepo.findByEmail(email);
	    if(user==null) {
	    	System.out.println("User not Found");
	    	throw new UsernameNotFoundException("User not found");
	    }
		return new UserPriniciple(user);
	}
	

}