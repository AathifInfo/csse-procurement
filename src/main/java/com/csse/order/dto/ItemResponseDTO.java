package com.csse.order.dto;

import com.csse.order.entity.Item;
import lombok.Data;

import java.util.Date;

@Data
public class ItemResponseDTO {
    private Integer statusCode;
    private Item item;
    private String description;
    private Date timeStamp;

    public ItemResponseDTO(Integer statusCode, Item itemId, String description, Date timeStamp) {
        this.statusCode = statusCode;
        this.item = itemId;
        this.description = description;
        this.timeStamp = timeStamp;
    }
}
