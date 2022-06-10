package com.assignment.account_service.exception;

import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class CustomerNotFoundException extends MethodArgumentNotValidException {
    /**
     * Constructor for {@link MethodArgumentNotValidException}.
     *
     * @param parameter     the parameter that failed validation
     * @param bindingResult the results of the validation
     */
    public CustomerNotFoundException(MethodParameter parameter, BindingResult bindingResult) {
        super(parameter, bindingResult);
    }
}
