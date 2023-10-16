package com.csse.order.dto;

import com.csse.order.entity.User;
import lombok.Data;

import java.util.Date;

@Data
public class UserResponseDTO {

    private Integer statusCode;
    private User user;
    private String description;
    private Date timestamp;

    public UserResponseDTO(Integer statusCode, User user, String description, Date timestamp) {
        this.statusCode = statusCode;
        this.user = user;
        this.description = description;
        this.timestamp = timestamp;
    }
}
