package com.assignment.transaction_service.service.impl;

import com.assignment.transaction_service.dto.request.CreateTransactionRequestDTO;
import com.assignment.transaction_service.dto.request.GetTransactionsRequestDTO;
import com.assignment.transaction_service.entity.Transaction;
import com.assignment.transaction_service.enums.TransactionType;
import com.assignment.transaction_service.repository.TransactionRepository;
import com.assignment.transaction_service.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    @Override
    public Transaction create(CreateTransactionRequestDTO dto) {
        if(TransactionType.INITIAL.equals(dto.getTransactionType())){
            return performInitialTransfer(dto);
        }
        return null;
    }

    @Override
    public List<Transaction> transactions(GetTransactionsRequestDTO dto) {
        return transactionRepository.findByFromAccountInOrToAccountInOrderByFromAccountAsc(dto.getAccountNumbers());
    }

    private Transaction performInitialTransfer(CreateTransactionRequestDTO dto) {
        Transaction transaction = new Transaction();
        transaction.setToAccount(dto.getToAccount());
        transaction.setAmount(dto.getAmount());
        transaction.setDateTime(dto.getDate());
        transaction.setType(dto.getTransactionType());
        transactionRepository.save(transaction);
        return transaction;
    }
}
