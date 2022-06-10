package com.assignment.account_service.service;

import com.assignment.account_service.common.dto.response.TransactionResponseDTO;
import com.assignment.account_service.dto.request.CreateAccountRequest;
import com.assignment.account_service.entity.Account;
import com.assignment.account_service.entity.Customer;
import com.assignment.account_service.feign.TransactionApiClient;
import com.assignment.account_service.mapper.AccountMapper;
import com.assignment.account_service.repository.AccountRepository;
import com.assignment.account_service.repository.CustomerRepository;
import com.assignment.account_service.service.impl.AccountServiceImpl;
import com.assignment.account_service.validator.AccountValidator;
import com.assignment.account_service.validator.AccountValidatorTest;
import com.assignment.common.exception.BadInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AccountServiceTest {

    @InjectMocks
    private AccountServiceImpl accountService;

    @Mock
    private AccountValidator accountValidator;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountMapper mapper;

    @Mock
    private TransactionApiClient transactionApiClient;
    @Mock
    private CustomerRepository customerRepository;

    private CreateAccountRequest createAccountRequest;
    private Customer customer;

    @BeforeEach
    public void setUp(){
        createAccountRequest = buildCreateRequest();
        Account account = new Account();
        account.setId(2L);
        account.setBalance(createAccountRequest.getInitialCredit());
        when(mapper.mapCreateRequestToEntity(any())).thenReturn(account);

        when(accountRepository.save(any())).thenReturn(account);

        ResponseEntity<TransactionResponseDTO> response = ResponseEntity.ok(new TransactionResponseDTO());
        when(transactionApiClient.createTransaction(any())).thenReturn(response);

    }

    @Test
    public void testCreateAccountSuccess(){
        customer = new Customer();
        customer.setId(createAccountRequest.getCustomerId());
        customer.setName("Samah");
        customer.setSurName("Daou");
        when(accountValidator.validateCreateAccount(createAccountRequest)).thenReturn(customer);
        when(customerRepository.findByIdAndStatus(any(), any())).thenReturn(Optional.of(customer));

        Account account = accountService.createAccount(createAccountRequest);
        assertNotNull(account);
        assertTrue(account.getId() > 0L);
        verify(transactionApiClient,times(1)).createTransaction(any());
        verify(accountValidator, times(1)).validateCreateAccount(createAccountRequest);
    }

    @Test
    public void testCreateAccount_BadInputException(){
        assertThrows(BadInputException.class,()->{
            accountService.createAccount(createAccountRequest);
        });
    }


    private CreateAccountRequest buildCreateRequest() {
        CreateAccountRequest createAccountRequest =  new CreateAccountRequest();
        createAccountRequest.setInitialCredit(new BigDecimal("12"));
        createAccountRequest.setCustomerId(1L);
        return createAccountRequest;
    }

}
