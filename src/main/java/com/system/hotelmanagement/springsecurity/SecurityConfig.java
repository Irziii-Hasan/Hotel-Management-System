//package com.system.hotelmanagement.springsecurity;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	    http
//	        .authorizeHttpRequests(auth -> auth
//	            .requestMatchers("hotelmanagementsystem/admin/**").hasRole("ADMIN")
//	            .requestMatchers("hotelmanagementsystem/client/**").hasRole("CLIENT")
//	            .requestMatchers("/public/**").permitAll()
//	            .anyRequest().authenticated()
//	        )
//	        .formLogin(form -> form
//	                .defaultSuccessUrl("/client/hello", true)
//	            );
//	    return http.build();
//	}
//
//}
