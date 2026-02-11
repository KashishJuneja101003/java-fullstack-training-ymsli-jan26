package com.bankapp.util;

import org.mapstruct.Mapper;

import com.bankapp.api.request.AccountRequest;
import com.bankapp.entities.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountRequest toDto(Account account);
}