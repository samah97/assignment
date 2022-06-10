package com.assignment.account_service.dto.request;

import com.assignment.common.request.BaseRequest;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Data
public class CreateAccountRequest extends BaseRequest {

    @Min(value = 1L, message = "Invalid Customer Id")
    private Long customerId;
    private BigDecimal initialCredit;

}
