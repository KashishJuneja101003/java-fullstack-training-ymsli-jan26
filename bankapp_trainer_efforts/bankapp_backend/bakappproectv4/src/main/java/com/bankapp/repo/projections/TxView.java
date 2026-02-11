package com.bankapp.repo.projections;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.bankapp.entities.BankTxType;

public interface TxView {
    BankTxType getType();
    BigDecimal getAmount();
    BigDecimal getBalanceAfterTx();
    LocalDateTime getTxTime();
}