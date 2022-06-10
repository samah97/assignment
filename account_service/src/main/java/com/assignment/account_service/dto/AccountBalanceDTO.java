package com.assignment.account_service.dto;

import com.assignment.account_service.common.dto.response.TransactionResponseDTO;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class AccountBalanceDTO {

    String name;
    String surName;
    BigDecimal balance;
    List<TransactionResponseDTO> transactions;


}
