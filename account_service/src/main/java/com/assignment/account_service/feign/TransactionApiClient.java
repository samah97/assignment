package com.assignment.account_service.feign;

import com.assignment.account_service.common.dto.request.CreateTransactionRequestDTO;
import com.assignment.account_service.common.dto.request.GetTransactionsRequestDTO;
import com.assignment.account_service.common.dto.response.GetTransactionsResponseDTO;
import com.assignment.account_service.common.dto.response.TransactionResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "transactionservice", url = "${feign.transactions.endpoint}/api/v1/transactions")
public interface TransactionApiClient {

    @PostMapping("create")
    ResponseEntity<TransactionResponseDTO> createTransaction(@RequestBody CreateTransactionRequestDTO dto);

    @PostMapping("all")
    ResponseEntity<GetTransactionsResponseDTO> transactions(@RequestBody GetTransactionsRequestDTO request);

}
