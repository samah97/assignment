package com.assignment.account_service.common.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class CreateTransactionRequestDTO {

    String fromAccount;
    String toAccount;
    String transactionType;
    BigDecimal amount;
    LocalDateTime date;


}
