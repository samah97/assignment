package com.assignment.transaction_service.mapper;

import com.assignment.transaction_service.dto.TransactionDTO;
import com.assignment.transaction_service.dto.response.CreateTransactionResponseDTO;
import com.assignment.transaction_service.entity.Transaction;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-11T01:07:59+0300",
    comments = "version: 1.5.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 11.0.15 (Private Build)"
)
@Component
public class TransactionMapperImpl implements TransactionMapper {

    @Override
    public CreateTransactionResponseDTO mapEntityToCreateResponse(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        CreateTransactionResponseDTO createTransactionResponseDTO = new CreateTransactionResponseDTO();

        return createTransactionResponseDTO;
    }

    @Override
    public TransactionDTO mapEntityToTransactionDTO(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        TransactionDTO transactionDTO = new TransactionDTO();

        transactionDTO.setId( transaction.getId() );
        transactionDTO.setFromAccount( transaction.getFromAccount() );
        transactionDTO.setToAccount( transaction.getToAccount() );
        if ( transaction.getType() != null ) {
            transactionDTO.setType( transaction.getType().name() );
        }
        transactionDTO.setAmount( transaction.getAmount() );
        transactionDTO.setDateTime( transaction.getDateTime() );

        return transactionDTO;
    }
}
