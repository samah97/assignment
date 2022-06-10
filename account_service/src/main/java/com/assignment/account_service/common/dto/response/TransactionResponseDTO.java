package com.assignment.account_service.common.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionResponseDTO {
    Long id;

    String fromAccount;

    String toAccount;
    String type;

    BigDecimal amount;
    LocalDateTime dateTime;

}
