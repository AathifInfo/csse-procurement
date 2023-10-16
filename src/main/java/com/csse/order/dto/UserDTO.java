package com.csse.order.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDTO {
    private long userId;

    @NotNull(message = "The user name is required")
    private String userName;

    @NotBlank(message = "The email is required")
    @Email
    private String userEmail;

    @NotBlank(message = "The password is required")
    private String password;
}
