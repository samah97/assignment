package com.assignment.transaction_service.dto.response;

import com.assignment.common.response.BaseResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateTransactionResponseDTO extends BaseResponse{



}
