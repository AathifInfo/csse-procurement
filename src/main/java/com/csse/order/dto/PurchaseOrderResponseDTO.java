package com.csse.order.dto;
import com.csse.order.entity.Order;
import com.csse.order.entity.PurchaseOrder;
import lombok.Data;

import java.util.Date;

@Data
public class PurchaseOrderResponseDTO {
    private Integer statusCode;
    private PurchaseOrder purchaseOrder;
    private String description;
    private Date timestamp;

    public PurchaseOrderResponseDTO(Integer statusCode, PurchaseOrder purchaseOrder, String description, Date timestamp) {
        this.statusCode = statusCode;
        this.purchaseOrder = purchaseOrder;
        this.description = description;
        this.timestamp = timestamp;
    }
}
