package com.assignment.account_service.repository;

import com.assignment.account_service.entity.Customer;
import com.assignment.account_service.enums.CustomerStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Optional<Customer> findByIdAndStatus(Long customerId, CustomerStatus customerStatus);


}
