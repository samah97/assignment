package com.assignment.transaction_service.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionDTO {

    Long id;

    String fromAccount;

    String toAccount;
    String type;

    BigDecimal amount;
    LocalDateTime dateTime;

}
