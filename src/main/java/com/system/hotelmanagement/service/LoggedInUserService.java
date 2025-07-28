package com.system.hotelmanagement.service;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.hotelmanagement.model.UserEntity;
import com.system.hotelmanagement.repository.UserRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class LoggedInUserService {
	
	@Autowired
	private final UserRepository userRepository;

	public Long getUsername(Principal principal) {
		String username = principal.getName();
		UserEntity user = userRepository.findByUsername(username);
		return user.getCustomer().getId();
		
		
				
	}
}
