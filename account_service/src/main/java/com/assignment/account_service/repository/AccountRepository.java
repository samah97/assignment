package com.assignment.account_service.repository;

import com.assignment.account_service.entity.Account;
import com.assignment.account_service.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {


}
