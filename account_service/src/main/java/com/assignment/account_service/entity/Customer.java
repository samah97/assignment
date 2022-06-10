package com.assignment.account_service.entity;

import com.assignment.account_service.enums.CustomerStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String surName;
    String phoneNumber;
    String email;
    @Enumerated(value = EnumType.STRING)
    CustomerStatus status;

    @OneToMany(mappedBy = "customer")
    List<Account> accountList;
}

