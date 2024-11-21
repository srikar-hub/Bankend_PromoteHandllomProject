package com.klu.BackendHandlooms.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.BackendHandlooms.Model.User;
import com.klu.BackendHandlooms.Service.SignUpInterface;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	
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
	
	@PostMapping("/login")
	public Map<String,Object> loginUser(@RequestBody Map<String,String> cred){
		String email = cred.get("email");
		String password = cred.get("password");
		Map<String,Object> response = si.login(email, password);
		return response;
		
	}
    
}
