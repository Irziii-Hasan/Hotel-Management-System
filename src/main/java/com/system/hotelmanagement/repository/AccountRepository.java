package com.system.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.hotelmanagement.model.AccountEntity;
import com.system.hotelmanagement.model.CustomerEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

	public CustomerEntity findByCustomerId(Long id);
}
