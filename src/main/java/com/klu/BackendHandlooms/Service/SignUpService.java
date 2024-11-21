package com.klu.BackendHandlooms.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.BackendHandlooms.Model.User;
import com.klu.BackendHandlooms.Repository.UserRepository;

@Service
public class SignUpService implements SignUpInterface{

	@Autowired
	private UserRepository ur;
	@Override
	public Map<String,String> addUser(User user) {
		Map<String,String> response = new HashMap<String,String>();
		if(ur.existsByEmail(user.getEmail())) {
			response.put("success","User with Email "+user.getEmail()+" already exists");
			return response;
		}
		ur.save(user);
	    response.put("success","User Saved SuccessFully");
		return response;
	}
	  
	public Map<String,Object> login(String email,String password){
		User user = ur.findByEmail(email);
		 Map<String, Object> response = new HashMap<>();
		if(user!=null && user.getPassword().equals(password)) {
			   response.put("success", true);
	           response.put("message", "Login successful");
		}
		else {
            response.put("success", false);
            response.put("message", "Invalid email or password");
        }

        return response;
		
		
	}

}
