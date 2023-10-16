package com.csse.order.dto;

import lombok.Data;

@Data
public class ItemDTO {
    private long itemId;

    private String itemName;

    private int qty;

    private float price;
}
