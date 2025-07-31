package com.system.hotelmanagement.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.system.hotelmanagement.dto.account.AccountRequestDTO;
import com.system.hotelmanagement.dto.account.AccountResponseDTO;
import com.system.hotelmanagement.service.CustomerService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping ("hotelmanagementsystem/customer/accountbalance")
public class AccountBalanceController {
	private final CustomerService customerService;
	AccountResponseDTO dto = new AccountResponseDTO();
	
	@GetMapping 
	public String showBalance(Principal principal, Model model ) {
		model.addAttribute("accountBalance",customerService.showBalance(principal));	
		return "accountbalance";
		
	}

	@PostMapping
	public String updateBalance(@ModelAttribute AccountRequestDTO dto) {
	    customerService.updateAccountBalance(dto);
	    return "redirect:/hotelmanagementsystem/customer/accountbalance";

	}
	
}
