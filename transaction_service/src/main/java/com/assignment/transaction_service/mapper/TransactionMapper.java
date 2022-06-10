package com.assignment.transaction_service.mapper;

import com.assignment.transaction_service.dto.TransactionDTO;
import com.assignment.transaction_service.dto.response.CreateTransactionResponseDTO;
import com.assignment.transaction_service.entity.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    CreateTransactionResponseDTO mapEntityToCreateResponse(Transaction transaction);

    TransactionDTO mapEntityToTransactionDTO(Transaction transaction);

}
