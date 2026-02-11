package com.bankapp.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferDto {
	private Integer fromAccountId;
	private Integer toAccountId;
	private BigDecimal amount;
	
	
}
