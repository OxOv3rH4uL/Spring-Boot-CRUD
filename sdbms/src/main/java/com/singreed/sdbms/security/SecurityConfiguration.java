package com.singreed.sdbms.security;

import static org.springframework.security.config.Customizer.withDefaults;


import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;





@Configuration
public class SecurityConfiguration {
	
	@Bean
	public InMemoryUserDetailsManager createDetailsManager() {
		
		String username="root";
    	String password="root";
    	
    	UserDetails userDetails1 = createNewUser(username, password);
		return new InMemoryUserDetailsManager(userDetails1);
    	
		
	}
	
	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passEncoder = input -> passwordEncoder().encode(input);
        
        UserDetails userDetails = User.builder()
                .passwordEncoder(passEncoder)
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@SuppressWarnings("removal")
	@Bean
    public SecurityFilterChain filter(HttpSecurity http) throws Exception{
    	http.authorizeHttpRequests(
    			auth->auth.anyRequest().authenticated()
    			);
    	http.formLogin(withDefaults());
    	http.csrf().disable();
    	http.headers().frameOptions().disable();
    	
    	return http.build();
    }
}
