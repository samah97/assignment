package com.assignment.account_service.common.dto.request;

import com.assignment.common.request.BaseRequest;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Set;

@Data
@Accessors(chain = true)
public class GetTransactionsRequestDTO extends BaseRequest {

    Set<String> accountNumbers;

}
