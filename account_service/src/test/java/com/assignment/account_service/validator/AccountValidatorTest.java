package com.assignment.account_service.validator;

import com.assignment.account_service.entity.Customer;
import com.assignment.account_service.repository.CustomerRepository;
import com.assignment.common.exception.BadInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class AccountValidatorTest {

    @InjectMocks
    private AccountValidator accountValidator;

    @Mock
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setUp(){

    }

    @Test
    public void validateCustomerSuccess(){
        when(customerRepository.findByIdAndStatus(any(), any())).thenReturn(Optional.of(new Customer()));
        Customer customer = accountValidator.validateCustomer(12L);
        assertNotNull(customer);
        verify(customerRepository, times(1)).findByIdAndStatus(any(), any());
    }

    @Test
    public void validateCustomer_BadInputException(){
        when(customerRepository.findByIdAndStatus(any(), any())).thenReturn(Optional.empty());
        assertThrows(BadInputException.class,  ()->{
            accountValidator.validateCustomer(12L);
        });
    }

}
