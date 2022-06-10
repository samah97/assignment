package com.assignment.account_service.handler;

import com.assignment.account_service.exception.AccountException;
import com.assignment.common.response.BaseErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@RequiredArgsConstructor
@ControllerAdvice
public class AccountErrorHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(AccountException.class)
    public ResponseEntity<BaseErrorResponse> handleAccountException(AccountException exception, WebRequest request){
        BaseErrorResponse response = new BaseErrorResponse();
        response.setCode(exception.getError().getCode());
        response.setMessage(
                messageSource.getMessage(exception.getMessage(),new Object[]{}, request.getLocale())
        );
        return ResponseEntity.badRequest().body(response);
    }

}
