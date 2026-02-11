package com.empapp.api.request;

import java.math.BigDecimal;

public record EmployeeDto(
        Long id,
        String name,
        BigDecimal salary
) {}