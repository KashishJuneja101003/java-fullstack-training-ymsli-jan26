package com.demo.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	private int orderId;
	private String orderName;
	private BigDecimal orderPrice;
	private LocalDateTime orderTime;
}
