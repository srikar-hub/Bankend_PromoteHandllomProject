package com.klu.BackendHandlooms.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.BackendHandlooms.model.User;
import com.klu.BackendHandlooms.repository.UserRepository;
import com.klu.BackendHandlooms.service.SignUpInterface;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	
	//private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	@Autowired
	private UserRepository ur;
	
	
	@Autowired
	private SignUpInterface si;
	
	@GetMapping("/")
	public String test() {
		return "Srikar";
	}
	@PostMapping("/signup")
	public Map<String, String> addUser(@RequestBody User user) {
		
	   return si.addUser(user);
	}
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
//		user.setPassword(encoder.encode(user.getPassword()));
		return si.register(user);
	}
	
	
	@PostMapping("/login")
	public Map<String,Object> loginUser(@RequestBody Map<String,String> cred){
		String email = cred.get("email");
		String password = cred.get("password");
		Map<String,Object> response = si.login(email, password);
		return response;
		
	}
	
	@PutMapping("/setPassword")
	public Map<String,Object> setPassword(@RequestBody Map<String,String> credentials){
		String email = credentials.get("email");
		String newPassword = credentials.get("password");
		Map<String,Object> response= si.updatePassword(email, newPassword);
		
		return response;
		
	}
	
	@PostMapping("/loginSecurity")
	public String login(@RequestBody User user) {
		 // Fetch the user from the database using email
	    User existingUser = ur.findByEmail(user.getEmail());
	    
	    if (existingUser == null) {
	        return "User not found";
	    }
	    
	    // Check if the passwords match
	    if (!existingUser.getPassword().equals(user.getPassword())) {
	        return "Invalid credentials";
	    }
	    
	    // Now pass the complete user object to the verify method (which will include userId)
	    return si.verify(existingUser);
	}

    
}
