package com.assignment.account_service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AppErrors {

    BAD_REQUEST("BD_001","invalid-data");

    private String code;
    private String message;

}
