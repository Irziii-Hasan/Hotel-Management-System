package com.system.hotelmanagement.service;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.system.hotelmanagement.dto.account.AccountRequestDTO;
import com.system.hotelmanagement.dto.account.AccountResponseDTO;
import com.system.hotelmanagement.dto.customer.CreateCustomerDTO;
import com.system.hotelmanagement.dto.customer.CustomerDTOConvertor;
import com.system.hotelmanagement.dto.customer.ViewCustomerDTO;
import com.system.hotelmanagement.model.CustomerEntity;
import com.system.hotelmanagement.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

	@Autowired
	private final CustomerRepository customerRepository;
	CustomerDTOConvertor dto = new CustomerDTOConvertor();
	private final LoggedInUserService inUserService;
	AccountResponseDTO accountResponseDTO = new AccountResponseDTO();
	AccountRequestDTO accountRequestDTO = new AccountRequestDTO();
	
	public ViewCustomerDTO addCustomer(CreateCustomerDTO customerDto) {
		CustomerEntity customer = dto.dtoToEntity(customerDto);
		customerRepository.save(customer);
		return dto.entityToDto(customer);
	}
	
	public List<ViewCustomerDTO> showCustomer(){
		List<CustomerEntity> customer = customerRepository.findAll();
		return customer.stream()
		.map(cList-> dto.entityToDto(cList))
		.toList();
	}
	
	public AccountResponseDTO showBalance(Principal principal) {
		Long customerId = inUserService.getUsername(principal);
		CustomerEntity customer = customerRepository.findById(customerId)
				.orElseThrow(()-> new RuntimeException("No customer found"));
		double currentBalance =  customer.getAccountBalance();
		accountResponseDTO.setCustomerId(customerId);
		accountResponseDTO.setAccountBalance(currentBalance);
		return accountResponseDTO;
	}
	
	
	
	public String updateAccountBalance(AccountRequestDTO dto) {
	    CustomerEntity customer = customerRepository.findById(dto.getCustomerId())
	        .orElseThrow(() -> new RuntimeException("No customer found"));

	    double currentBalance = customer.getAccountBalance();
	    if (dto.getBalance() <= 0) {
	        return "Invalid Amount";
	    }

	    customer.setAccountBalance(currentBalance + dto.getBalance());
	    customerRepository.save(customer);

	    return "Amount successfully Added";
	}
	
	
	public boolean withdrawBalance(Long id, double amount) {
		CustomerEntity customer = customerRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("No customer found"));
		double currentBalance = customer.getAccountBalance();
		if(currentBalance>=amount) {
	        customer.setAccountBalance(currentBalance - amount);
	        customerRepository.save(customer);

			return true;
		}else {
			return false;
		}
	}
}
