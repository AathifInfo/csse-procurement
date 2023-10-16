package com.csse.order.dto;


import lombok.Data;

@Data
public class InquiryDTO {

    private long inquiryId;

    private String companyName;

    private String personName;

    private String contactNumber;

    private String subject;

    private String message;
}
