package com.csse.order.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PurchaseOrderDTO {
    private long purchaseOrderId;

    @NotNull(message = "The supplier details is required")
    private String supplierName;

    @NotNull(message = "The supplier details is required")
    private String companyName;

    @NotNull(message = "The ContactNo is required")
    private String contactNo;

    @NotNull(message = "The quantity is required")
    private String totalQty;

    @NotNull(message = "The Price is required")
    private float price;
}
