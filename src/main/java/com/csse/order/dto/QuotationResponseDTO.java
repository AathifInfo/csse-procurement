package com.csse.order.dto;

import com.csse.order.entity.Inquiry;
import com.csse.order.entity.Quotation;
import lombok.Data;

import java.util.Date;

@Data
public class QuotationResponseDTO {
    private Integer statusCode;
    private Quotation quotation;
    private String description;
    private Date timestamp;

    public QuotationResponseDTO(Integer statusCode, Quotation quotation, String description, Date timestamp) {
        this.statusCode = statusCode;
        this.quotation = quotation;
        this.description = description;
        this.timestamp = timestamp;
    }

}
