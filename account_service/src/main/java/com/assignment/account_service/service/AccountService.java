package com.assignment.account_service.service;

import com.assignment.account_service.dto.AccountBalanceDTO;
import com.assignment.account_service.dto.AccountDTO;
import com.assignment.account_service.dto.request.CreateAccountRequest;
import com.assignment.account_service.dto.request.GetAccountBalanceRequestDTO;
import com.assignment.account_service.entity.Account;

public interface AccountService {

    Account createAccount(CreateAccountRequest createAccountRequest);

    AccountBalanceDTO balance(GetAccountBalanceRequestDTO dto);
}
