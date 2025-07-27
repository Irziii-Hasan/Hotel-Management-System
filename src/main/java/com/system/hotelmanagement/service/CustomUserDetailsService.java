//package com.system.hotelmanagement.service;
//
//import com.system.hotelmanagement.model.UserEntity;
//import com.system.hotelmanagement.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//
//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//    
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        System.out.println("Loading user: " + username);
//
//        if ("admin".equals(username)) {
//            // InMemory Admin
//            return org.springframework.security.core.userdetails.User
//                    .withUsername("admin")
//                    .password("{noop}admin123")
//                    .roles("ADMIN")
//                    .build();
//        }
//
//        // Client from DB
//        UserEntity user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//
//        return org.springframework.security.core.userdetails.User
//                .withUsername(user.getUsername())
//                .password(user.getPassword())
//                .roles(user.getRole())
//                .build();
//    }
//
//
//}
