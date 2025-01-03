package com.klu.BackendHandlooms.service;

import java.util.Map;

import com.klu.BackendHandlooms.model.User;

public interface SignUpInterface {
	
	
	public Map<String,String> addUser(User user);
	
	public Map<String,Object> login(String email,String password);
	
	public User register(User user);
	
	public Map<String,Object> updatePassword(String email,String password);

	public String verify(User user);
}
