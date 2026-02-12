package com.bankapp.api.request;

import java.math.BigDecimal;

public record WithdrawRequest ( Integer accountId,BigDecimal amount) {}