package com.csse.order.dto;

import com.csse.order.entity.Order;
import lombok.Data;

import java.util.Date;


@Data
public class OrderResponseDTO {
    private Integer statusCode;
    private Order order;
    private String description;
    private Date timestamp;

    public OrderResponseDTO(Integer statusCode, Order orderId, String description, Date timestamp) {
        this.statusCode = statusCode;
        this.order = orderId;
        this.description = description;
        this.timestamp = timestamp;
    }
}
