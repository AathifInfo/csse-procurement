package com.csse.order.dto;

import com.csse.order.entity.Contract;
import com.csse.order.entity.Quotation;
import lombok.Data;

import java.util.Date;

@Data
public class ContractResponseDTO {
    private Integer statusCode;
    private Contract contract;
    private String description;
    private Date timestamp;

    public ContractResponseDTO(Integer statusCode, Contract contract, String description, Date timestamp) {
        this.statusCode = statusCode;
        this.contract = contract;
        this.description = description;
        this.timestamp = timestamp;
    }
}
