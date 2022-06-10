package com.assignment.transaction_service.controller;

import com.assignment.transaction_service.dto.request.CreateTransactionRequestDTO;
import com.assignment.transaction_service.dto.request.GetTransactionsRequestDTO;
import com.assignment.transaction_service.dto.response.CreateTransactionResponseDTO;
import com.assignment.transaction_service.dto.response.GetTransactionsResponseDTO;
import com.assignment.transaction_service.mapper.TransactionMapper;
import com.assignment.transaction_service.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionMapper transactionMapper;

    @PostMapping("create")
    ResponseEntity<CreateTransactionResponseDTO> create(@RequestBody CreateTransactionRequestDTO request){
        return ResponseEntity.ok()
                .body(transactionMapper.mapEntityToCreateResponse(
                        transactionService.create(request)
                        )
                );
    }

    @PostMapping("all")
    ResponseEntity<GetTransactionsResponseDTO> transactions(@RequestBody GetTransactionsRequestDTO request){
        return ResponseEntity.ok()
                .body(new GetTransactionsResponseDTO()
                                .setTransactions(transactionService.transactions(request)
                                        .stream().map(transactionMapper::mapEntityToTransactionDTO)
                                        .collect(Collectors.toList())
                                )
                );
    }
}
