package com.assignment.account_service.exception;

import com.assignment.account_service.enums.AccountError;
import lombok.Data;


@Data
public class AccountException extends RuntimeException{

    AccountError error;

    public AccountException(AccountError error){

    }

}
