package com.assignment.account_service.dto.request;

import com.assignment.common.request.BaseRequest;
import lombok.Data;

@Data
public class GetAccountBalanceRequestDTO extends BaseRequest {
    Long customerId;
}
