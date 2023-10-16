package com.csse.order.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ItemDTO {
    private long itemId;


    @NotBlank(message = "The item name is required")
    private String itemName;

    @NotBlank(message = "The qty is required")
    private int qty;

    @NotBlank(message = "The price is required")
    private float price;
}
