package com.assignment.common.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BadRequestErrorResponse extends BaseErrorResponse{

    private Map errors;
}
