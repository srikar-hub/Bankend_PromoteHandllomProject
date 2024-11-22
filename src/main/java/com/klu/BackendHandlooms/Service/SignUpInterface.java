package com.klu.BackendHandlooms.Service;

import java.util.Map;

import com.klu.BackendHandlooms.Model.User;

public interface SignUpInterface {
	
	
	public Map<String,String> addUser(User user);
	
	public Map<String,Object> login(String email,String password);
	
	public User register(User user);
}
