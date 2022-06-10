package com.assignment.account_service.validator;

import com.assignment.account_service.dto.request.CreateAccountRequest;
import com.assignment.account_service.entity.Customer;
import com.assignment.account_service.enums.CustomerStatus;
import com.assignment.account_service.exception.CustomerNotFoundException;
import com.assignment.account_service.repository.AccountRepository;
import com.assignment.account_service.repository.CustomerRepository;
import com.assignment.common.exception.BadInputException;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AccountValidator {

    private final CustomerRepository customerRepository;

    public Customer validateCreateAccount(CreateAccountRequest dto){
        return validateCustomer(dto.getCustomerId());
    }

    public Customer validateCustomer(Long customerId){
        return customerRepository.findByIdAndStatus(customerId, CustomerStatus.ACTIVE)
                .orElseThrow(() -> new BadInputException("Invalid Customer Id"));
    }
}
