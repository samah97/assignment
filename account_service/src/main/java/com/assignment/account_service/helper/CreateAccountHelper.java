package com.assignment.account_service.helper;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CreateAccountHelper {


    public static String generateAccountNumber(Long customerId){
        return String.valueOf(ZonedDateTime.now().toInstant().toEpochMilli());
    }




}
