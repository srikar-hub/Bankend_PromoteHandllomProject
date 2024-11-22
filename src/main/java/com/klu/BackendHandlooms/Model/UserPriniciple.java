package com.klu.BackendHandlooms.Model;

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
	// TODO Auto-generated method stub
	return Collections.emptyList();
}
@Override
public String getPassword() {
	// TODO Auto-generated method stub
	return user.getPassword();
}
@Override
public String getUsername() {
	// TODO Auto-generated method stub
	return user.getEmail();
}

}
