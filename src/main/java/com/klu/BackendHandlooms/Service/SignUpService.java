	package com.klu.BackendHandlooms.service;
	
	import java.util.HashMap;
	import java.util.Map;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.security.authentication.AuthenticationManager;
	import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
	import org.springframework.security.core.Authentication;
	import org.springframework.stereotype.Service;
	
	import com.klu.BackendHandlooms.model.User;
	import com.klu.BackendHandlooms.repository.UserRepository;
	
	@Service
	public class SignUpService implements SignUpInterface{
	
		
		@Autowired
		private JWTService jwtservice;
		@Autowired
		private AuthenticationManager authManager;
		
		
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
	
		@Override
		public User register(User user) {
				return ur.save(user);
		}
	
		@Override
		public Map<String, Object> updatePassword(String email, String password) {
			Map<String,Object> res = new HashMap<String,Object>();
			User user = ur.findByEmail(email);
			if(user != null) {
				user.setPassword(password);
			    ur.save(user);
				res.put("success",true);
			    res.put("message","Password Changed Successful");
			    return res;
			    
			}
			 res.put("success", false);
	         res.put("message", "Invalid email or password");
			return res;
		}
	
		@Override
		public String verify(User user) {
			Authentication authentication  = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
			if(authentication.isAuthenticated()) {
				return jwtservice.generateToken(user.getEmail());
			}
			return "fail";
		}
		
		
	
	}
