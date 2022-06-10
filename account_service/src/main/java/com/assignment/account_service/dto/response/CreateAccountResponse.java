package com.assignment.account_service.dto.response;

import com.assignment.account_service.enums.AccountStatus;
import com.assignment.common.response.BaseResponse;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateAccountResponse extends BaseResponse {
    private Long id;
    private String accountNumber;
    private AccountStatus active;
    BigDecimal balance;
}
