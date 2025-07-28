package com.system.hotelmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.hotelmanagement.dto.registration.RegistrationRequestDTO;
import com.system.hotelmanagement.service.RegistrationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping ("hotelmanagementsystem/Registration")
@RequiredArgsConstructor
public class RegistrationController {

	@Autowired
	private final RegistrationService registrationService;
	
	@PostMapping
	public String doRegistration(@RequestBody RegistrationRequestDTO dto) {
		return registrationService.registration(dto);
	}
	
}
