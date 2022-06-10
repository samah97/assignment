package com.assignment.account_service.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDTO {
    private String customerId;
    private String accountNumber;
    private BigDecimal amount;
}
