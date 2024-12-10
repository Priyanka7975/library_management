package com.example.library.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsService userDetailsService;
	@Bean
	public DaoAuthenticationProvider authProvider() {
		
		 DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		 provider.setUserDetailsService(userDetailsService);
		 provider.setPasswordEncoder(new BCryptPasswordEncoder());
		 
		  return provider;
	}
	@Bean 
	public PasswordEncoder passwordEncoder() { 
		return new BCryptPasswordEncoder(); }
	@Override 
	protected void configure(HttpSecurity http) throws Exception { 
		http.csrf().disable() 
		.authorizeRequests() 
		.antMatchers("/user/save").permitAll()
		.antMatchers("/book/get/**").permitAll()
		.antMatchers("/book/save").hasAuthority("LIBRARIAN")
		.antMatchers("/book/delete/**").hasAuthority("LIBRARIAN")
		.antMatchers("/user/approve/**").permitAll()
		.antMatchers("/login").permitAll()
		.anyRequest().authenticated() 
		.and() 
		.formLogin().defaultSuccessUrl("/", true).permitAll() 
		.and() .logout().logoutSuccessUrl("/login").permitAll();
		}
}
