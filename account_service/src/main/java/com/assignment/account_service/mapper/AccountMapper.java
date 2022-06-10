package com.assignment.account_service.mapper;

import com.assignment.account_service.dto.request.CreateAccountRequest;
import com.assignment.account_service.dto.response.CreateAccountResponse;
import com.assignment.account_service.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    CreateAccountResponse mapEntityToCreateAccountResponse(Account account);
    Account mapCreateRequestToEntity(CreateAccountRequest dto);

}
