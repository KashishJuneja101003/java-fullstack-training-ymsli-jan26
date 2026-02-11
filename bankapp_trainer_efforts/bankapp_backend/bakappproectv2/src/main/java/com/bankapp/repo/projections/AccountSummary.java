package com.bankapp.repo.projections;

import java.math.BigDecimal;

public interface AccountSummary {
    Integer getId();
    String getName();
    BigDecimal getBalance();
}
