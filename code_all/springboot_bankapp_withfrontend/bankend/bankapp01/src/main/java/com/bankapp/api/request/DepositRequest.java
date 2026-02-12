package com.bankapp.api.request;

import java.math.BigDecimal;

public record DepositRequest(Integer accountId,BigDecimal amount) {}