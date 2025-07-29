package com.system.hotelmanagement.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.hotelmanagement.service.LoggedInUserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class LoggedInUserController {

	@Autowired
	private final LoggedInUserService loggedInUserService;
	
	
	public String getUserId(Model model, Principal principal) {
		Long customerId = loggedInUserService.getUsername(principal);
		model.addAttribute("customerId", customerId);
	    return "dashboard";
		
		
	}
}

