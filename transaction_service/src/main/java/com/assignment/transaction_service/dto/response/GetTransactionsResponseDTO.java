package com.assignment.transaction_service.dto.response;

import com.assignment.common.response.BaseResponse;
import com.assignment.transaction_service.dto.TransactionDTO;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class GetTransactionsResponseDTO extends BaseResponse {

    List<TransactionDTO> transactions;
}
