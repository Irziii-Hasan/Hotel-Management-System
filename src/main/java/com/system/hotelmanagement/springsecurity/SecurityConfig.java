package com.system.hotelmanagement.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
    private CustomLoginSuccessHandler customLoginSuccessHandler;

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("hotelmanagementsystem/admin/**").hasRole("ADMIN")
	            .requestMatchers("hotelmanagementsystem/customer/**").hasRole("CUSTOMER")
	            .requestMatchers("/hotelmanagementsystem/registration").permitAll()
	            .requestMatchers("/hotelmanagementsystem/login").permitAll()
	            .anyRequest().authenticated()
	        )
	        .formLogin(form -> form
	        	    .loginPage("/hotelmanagementsystem/login")
	        	    .loginProcessingUrl("/hotelmanagementsystem/login")
	        	    .successHandler(customLoginSuccessHandler) 
	        	    .permitAll()
	        	)
	        .logout(logout -> logout
	                .logoutUrl("/logout")
	                .logoutSuccessUrl("/hotelmanagementsystem/login?logout")
	                .permitAll()
	            );
	    return http.build();
	}

}