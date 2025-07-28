package com.system.hotelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.system.hotelmanagement.dto.registration.RegistrationRequestDTO;
import com.system.hotelmanagement.service.RegistrationService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping ("hotelmanagementsystem")
@RequiredArgsConstructor
public class RegistrationController {

	@Autowired
	private final RegistrationService registrationService;
	
	 	@GetMapping  ("/registration")
	    public String showRegistrationForm(Model model) {
	        model.addAttribute("user", new RegistrationRequestDTO());
	        return "registration"; // thymeleaf template name
	    }
	 
		@GetMapping("/login")
		public String loginPage() {
		    return "login"; // login.html
		}

	    @PostMapping ("/registration")
	    public String doRegistration(@ModelAttribute("user") RegistrationRequestDTO dto) {
	        registrationService.registration(dto);
	        return "redirect:/success"; // ya koi bhi next page
	    }

	    
	    
	    
}
