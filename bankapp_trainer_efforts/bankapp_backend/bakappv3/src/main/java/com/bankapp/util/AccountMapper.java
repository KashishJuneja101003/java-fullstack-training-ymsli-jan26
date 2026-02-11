package com.bankapp.util;

import org.mapstruct.Mapper;

import com.bankapp.dto.AccountDto;
import com.bankapp.entities.Account;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDto toDto(Account account);
}