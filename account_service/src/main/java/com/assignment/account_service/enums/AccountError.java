package com.assignment.account_service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AccountError {

    ACCOUNT_EXIST("ACC_001","account-exist");

    String code;
    String message;
}
