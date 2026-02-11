package com.bankapp.dto;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private int id;
    private String name;
    private BigDecimal balance;
    
	public AccountDto(String name, BigDecimal balance) {
		super();
		this.name = name;
		this.balance = balance;
	}
    
    
}