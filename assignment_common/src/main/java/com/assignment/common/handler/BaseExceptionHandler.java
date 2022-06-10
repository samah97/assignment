package com.assignment.common.handler;

import com.assignment.common.enums.AppErrors;
import com.assignment.common.exception.BadInputException;
import com.assignment.common.response.BadRequestErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Priority;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@ControllerAdvice
@Priority(10)
public class BaseExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BadRequestErrorResponse> handleBadRequestException(MethodArgumentNotValidException ex, WebRequest request){
        return ResponseEntity.badRequest().body(
                createBadResponse(
                        AppErrors.BAD_REQUEST,
                        messageSource.getMessage(AppErrors.BAD_REQUEST.getMessage(),new Object[]{}, request.getLocale()),
                        ex.getAllErrors()
                )
        );
    }


    @ExceptionHandler(BadInputException.class)
    public ResponseEntity<BadRequestErrorResponse> handleBadInputException(BadInputException ex, WebRequest request){
        return ResponseEntity.badRequest().body(
                createBadResponse(
                        AppErrors.BAD_REQUEST,
                        ex.getMessage(),
                        null
                )
        );
    }

    BadRequestErrorResponse createBadResponse(AppErrors appError, String message, List<ObjectError> errorList){
        BadRequestErrorResponse response = new BadRequestErrorResponse();
        response.setCode(appError.getCode());
        response.setMessage(message);
        if(errorList!=null){
            response.setErrors(
                    buildErrorsMap(errorList)
            );
        }
        return response;
    }



    Map<String, String> buildErrorsMap(List<ObjectError> errorList){
        Map<String, String> errors = new HashMap<>();
        errorList.forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}
