package com.klu.BackendHandlooms.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPriniciple implements UserDetails{
private User user;
public UserPriniciple(User user){
	this.user=user;
}
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	
	return Collections.emptyList();
}
@Override
public String getPassword() {
	
	return user.getPassword();
}
@Override
public String getUsername() {
	
	return user.getEmail();
}

}
