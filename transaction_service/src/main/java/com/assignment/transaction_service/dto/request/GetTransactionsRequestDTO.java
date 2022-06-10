package com.assignment.transaction_service.dto.request;

import com.assignment.common.request.BaseRequest;
import lombok.Data;

import java.util.Set;

@Data
public class GetTransactionsRequestDTO extends BaseRequest {
    Set<String> accountNumbers;
}
