package com.csse.order.service;

import com.csse.order.dto.UserDTO;
import com.csse.order.dto.UserResponseDTO;
import com.csse.order.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    UserResponseDTO createUser(UserDTO userDTO);

    ResponseEntity<List<User>> getUsers();

    ResponseEntity<User> getUserById(long id);

    ResponseEntity<User> updateUser(long id, UserDTO userDTO);

    UserResponseDTO deleteUser(long id);

    UserResponseDTO deleteUsers();
}
