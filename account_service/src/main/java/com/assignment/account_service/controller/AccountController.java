package com.assignment.account_service.controller;

import com.assignment.account_service.dto.AccountBalanceDTO;
import com.assignment.account_service.dto.request.CreateAccountRequest;
import com.assignment.account_service.dto.request.GetAccountBalanceRequestDTO;
import com.assignment.account_service.dto.response.CreateAccountResponse;
import com.assignment.account_service.mapper.AccountMapper;
import com.assignment.account_service.service.AccountService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/api/v1/account")
@RestController
public class AccountController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @PostMapping("create")
    public ResponseEntity<CreateAccountResponse> create(@Valid @RequestBody CreateAccountRequest request){
        return ResponseEntity.ok(
                accountMapper.mapEntityToCreateAccountResponse(
                        accountService.createAccount(request)
                )
        );
    }

    @PostMapping("balance")
    public ResponseEntity<AccountBalanceDTO> balance(@RequestBody GetAccountBalanceRequestDTO request){
        return ResponseEntity.ok(
                accountService.balance(request)
        );
    }

}

