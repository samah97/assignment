package com.assignment.account_service.controller;

import com.assignment.account_service.dto.AccountBalanceDTO;
import com.assignment.account_service.dto.response.CreateAccountResponse;
import com.assignment.account_service.entity.Account;
import com.assignment.account_service.mapper.AccountMapper;
import com.assignment.account_service.repository.CustomerRepository;
import com.assignment.account_service.service.AccountService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @MockBean
    private AccountMapper accountMapper;

    @MockBean
    private CustomerRepository customerRepository;

    @Test
    public void testCreate() throws Exception {
        CreateAccountResponse createAccountResponse = new CreateAccountResponse();
        createAccountResponse.setAccountNumber("124123123");
        when(accountMapper.mapEntityToCreateAccountResponse(any())).thenReturn(createAccountResponse);
        when(accountService.createAccount(any())).thenReturn(new Account());

        mockMvc.perform(
                        post("/api/v1/account/create")
                                .content("{\"customerId\":1,\"initialCredit\":500}")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                ).andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.accountNumber").exists());
    }

    @Test
    public void testBalance() throws Exception {
        AccountBalanceDTO accountBalanceDTO = AccountBalanceDTO.builder().balance(new BigDecimal("20")).build();
        when(accountService.balance(any())).thenReturn(accountBalanceDTO);
        mockMvc.perform(
                post("/api/v1/account/balance")
                        .content("{\"customerId\":3}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.balance").exists());

    }

}
