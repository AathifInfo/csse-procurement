package com.csse.order.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class OrderDTO {

    private long orderId;

    @NotNull(message = "The date is required")
//    @Future(message = "Order date must be in the future")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date;

    @NotBlank(message = "The order address is required")
    @Size(min = 3, max = 40, message = "The order address must be from 3 to 40 characters")
    private String address;

    @NotNull(message = "The supplier details is required")
    private String supplierDetails;

    @NotNull(message = "The company details is required")
    private String companyDetails;

    @NotNull(message = "The quantity is required")
    private String qty;

}
