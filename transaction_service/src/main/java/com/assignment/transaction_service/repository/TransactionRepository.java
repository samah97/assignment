package com.assignment.transaction_service.repository;

import com.assignment.transaction_service.entity.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    @Query("select t from transaction t " +
            "where t.fromAccount in :accountList or t.toAccount in :accountList " +
            "order by t.dateTime desc")
    List<Transaction> findByFromAccountInOrToAccountInOrderByFromAccountAsc(@Param("accountList") Set<String> accounts);

}
