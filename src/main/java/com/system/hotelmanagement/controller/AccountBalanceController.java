package com.system.hotelmanagement.controller;

import java.security.Principal;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	@ResponseBody
	public String updateBalance(@RequestBody AccountRequestDTO dto) {
		System.out.println(dto.getBalance()+"  "+dto.getCustomerId());
		return customerService.updateAccountBalance(dto);
	}
	
}
