package com.assignment.account_service.entity;

import com.assignment.account_service.enums.AccountStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private String accountNumber;
    private String accountName;
    private AccountStatus active;
    BigDecimal balance;
}
