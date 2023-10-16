package com.csse.order.dto;

import com.csse.order.entity.Inquiry;
import lombok.Data;

import java.util.Date;

@Data
public class InquiryResponseDTO {
    private Integer statusCode;
    private Inquiry inquiry;
    private String description;
    private Date timestamp;

    public InquiryResponseDTO(Integer statusCode, Inquiry inquiry, String description, Date timestamp) {
        this.statusCode = statusCode;
        this.inquiry = inquiry;
        this.description = description;
        this.timestamp = timestamp;
    }
}
