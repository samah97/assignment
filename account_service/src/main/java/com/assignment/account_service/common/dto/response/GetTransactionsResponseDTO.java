package com.assignment.account_service.common.dto.response;

import com.assignment.common.response.BaseResponse;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class GetTransactionsResponseDTO extends BaseResponse {
    List<TransactionResponseDTO> transactions;
}
