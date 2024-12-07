package com.example.library.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.library.entity.User;
import com.example.library.repository.UserRepo;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService{
	@Autowired
private UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepo.findByUsername(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("User does not exist.");
		}
//	 
//	List<SimpleGrantedAuthority> authorities = new ArrayList<>(); 
//	for (String role : user.getRoles().split(",")) {
//		authorities.add(new SimpleGrantedAuthority(role)); 
//		} 
//	return new org.springframework.security.core.userdetails.User(
//			user.getUsername(),
//			user.getPassword(), 
//			authorities);
		return new UserDetailsImpl(user);
		
	}

	

}
