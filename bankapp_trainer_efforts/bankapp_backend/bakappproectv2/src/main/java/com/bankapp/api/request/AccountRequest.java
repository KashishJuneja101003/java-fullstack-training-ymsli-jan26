package com.bankapp.api.request;

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
public class AccountRequest {
    private int id;
    private String name;
    private BigDecimal balance;
    
	public AccountRequest(String name, BigDecimal balance) {
		super();
		this.name = name;
		this.balance = balance;
	}
    
    
}