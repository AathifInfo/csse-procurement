package com.csse.order.dto;

import lombok.Data;

@Data
public class OrderDTO {

    private long orderId;
    private String date;
    private String address;
    private String supplierDetails;
    private String companyDetails;
    private String qty;

}
