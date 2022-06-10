package com.assignment.account_service.service.impl;

import com.assignment.account_service.common.dto.request.CreateTransactionRequestDTO;
import com.assignment.account_service.common.dto.request.GetTransactionsRequestDTO;
import com.assignment.account_service.common.dto.response.GetTransactionsResponseDTO;
import com.assignment.account_service.common.dto.response.TransactionResponseDTO;
import com.assignment.account_service.dto.AccountBalanceDTO;
import com.assignment.account_service.dto.request.CreateAccountRequest;
import com.assignment.account_service.dto.request.GetAccountBalanceRequestDTO;
import com.assignment.account_service.entity.Account;
import com.assignment.account_service.entity.Customer;
import com.assignment.account_service.enums.AccountSign;
import com.assignment.account_service.enums.AccountStatus;
import com.assignment.account_service.feign.TransactionApiClient;
import com.assignment.account_service.helper.CreateAccountHelper;
import com.assignment.account_service.mapper.AccountMapper;
import com.assignment.account_service.repository.AccountRepository;
import com.assignment.account_service.repository.CustomerRepository;
import com.assignment.account_service.service.AccountService;
import com.assignment.account_service.validator.AccountValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper mapper;
    private final TransactionApiClient transactionApiClient;
    private final AccountValidator accountValidator;
    private final CustomerRepository customerRepository;

    @Override
    public Account createAccount(CreateAccountRequest dto) {
        Customer customer = accountValidator.validateCreateAccount(dto);
        Account account = mapper.mapCreateRequestToEntity(dto);
        initAccount(account, customer);
        account = accountRepository.save(account);
        createTransaction(account, dto.getInitialCredit());
        return account;
    }


    void initAccount(Account account, Customer customer){
        account.setActive(AccountStatus.ACTIVE);
        account.setBalance(BigDecimal.ZERO);
        account.setAccountNumber(CreateAccountHelper.generateAccountNumber(customer.getId()));
        account.setCustomer(customer);
    }

    @Override
    public AccountBalanceDTO balance(GetAccountBalanceRequestDTO requestDTO) {
        Customer customer = accountValidator.validateCustomer(requestDTO.getCustomerId());
        BigDecimal balance = customer.getAccountList()
                .stream()
                .map(account -> account.getBalance())
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);

        List<TransactionResponseDTO> transactions = retrieveTransactions(
                customer.getAccountList().stream().map(account -> account.getAccountNumber())
                        .collect(Collectors.toSet())
        );

        return AccountBalanceDTO
                .builder()
                .name(customer.getName())
                .surName(customer.getSurName())
                .balance(balance)
                .transactions(transactions)
                .build();
    }

    List<TransactionResponseDTO> retrieveTransactions(Set<String> accounts){
        ResponseEntity<GetTransactionsResponseDTO> transactionsResponse =
                transactionApiClient.transactions(
                        new GetTransactionsRequestDTO().setAccountNumbers(accounts)
                );
        if(HttpStatus.OK.equals(transactionsResponse.getStatusCode())){
            return transactionsResponse.getBody().getTransactions() ;
        }
        return new ArrayList<>();
    }

    private void createTransaction(Account account, BigDecimal initialCredit) {
        if(BigDecimal.ZERO.compareTo(initialCredit) > 0 ){
            return;
        }
        ResponseEntity<TransactionResponseDTO> transactionResponse = transactionApiClient.createTransaction(
                CreateTransactionRequestDTO.builder()
                        .toAccount(account.getAccountNumber().toString())
                        .date(LocalDateTime.now())
                        .amount(initialCredit)
                        .transactionType("INITIAL")
                        .build()
        );
        if(HttpStatus.OK.equals(transactionResponse.getStatusCode())){
               updateAccountBalance(account, initialCredit, AccountSign.add);
        }
    }

    void updateAccountBalance(Account account, BigDecimal amount, AccountSign sign){
        if(AccountSign.add.equals(sign)){
            account.setBalance(
                    account.getBalance().add(amount)
            );
        }else if (AccountSign.deduct.equals(sign)){
            account.setBalance(
                    account.getBalance().subtract(amount)
            );
        }
        accountRepository.save(account);
    }
}
