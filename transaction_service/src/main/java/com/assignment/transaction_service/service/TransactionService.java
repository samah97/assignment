package com.assignment.transaction_service.service;

import com.assignment.transaction_service.dto.request.CreateTransactionRequestDTO;
import com.assignment.transaction_service.dto.request.GetTransactionsRequestDTO;
import com.assignment.transaction_service.entity.Transaction;

import java.util.List;

public interface TransactionService {

    Transaction create(CreateTransactionRequestDTO dto);

    List<Transaction> transactions(GetTransactionsRequestDTO dto);

}
