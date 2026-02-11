package com.bankapp.api.response;

import java.math.BigDecimal;
import java.util.List;

import com.bankapp.repo.projections.TxView;

public record AccountWithTxResponse(
    int id,
    String name,
    BigDecimal balance,
    List<TxView> transactions
) {}
