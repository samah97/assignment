package com.assignment.transaction_service.entity;

import com.assignment.transaction_service.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fromAccount;

    private String toAccount;

    @Enumerated(EnumType.STRING)
    private TransactionType type;

    private BigDecimal amount;
    private LocalDateTime dateTime;
}
