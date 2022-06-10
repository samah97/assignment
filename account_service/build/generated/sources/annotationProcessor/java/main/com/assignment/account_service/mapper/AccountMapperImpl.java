package com.assignment.account_service.mapper;

import com.assignment.account_service.dto.request.CreateAccountRequest;
import com.assignment.account_service.dto.response.CreateAccountResponse;
import com.assignment.account_service.entity.Account;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-11T00:54:15+0300",
    comments = "version: 1.5.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 11.0.15 (Private Build)"
)
@Component
public class AccountMapperImpl implements AccountMapper {

    @Override
    public CreateAccountResponse mapEntityToCreateAccountResponse(Account account) {
        if ( account == null ) {
            return null;
        }

        CreateAccountResponse createAccountResponse = new CreateAccountResponse();

        createAccountResponse.setId( account.getId() );
        createAccountResponse.setAccountNumber( account.getAccountNumber() );
        createAccountResponse.setActive( account.getActive() );
        createAccountResponse.setBalance( account.getBalance() );

        return createAccountResponse;
    }

    @Override
    public Account mapCreateRequestToEntity(CreateAccountRequest dto) {
        if ( dto == null ) {
            return null;
        }

        Account account = new Account();

        return account;
    }
}
