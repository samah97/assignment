package com.assignment.transaction_service.dto.request;

import com.assignment.common.request.BaseRequest;
import com.assignment.transaction_service.enums.TransactionType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class CreateTransactionRequestDTO extends BaseRequest {

    String fromAccount;
    String toAccount;
    TransactionType transactionType;
    BigDecimal amount;
    LocalDateTime date;

}
