package com.csse.order.controller;


import com.csse.order.common.CommonResponse;
import com.csse.order.dto.UserDTO;
import com.csse.order.dto.UserResponseDTO;
import com.csse.order.entity.User;
import com.csse.order.service.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    UserService userService;

    /**
     * Create user request
     *
     * @param userDTO - required dto to create an user
     * @return success or failed response from user creation
     * @author aathif
     */
    @PostMapping("/user")
    public ResponseEntity<CommonResponse> createUser(@Valid @RequestBody UserDTO userDTO){
        logger.info("UserController -> createUser() => start");
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setTimestamp(LocalDateTime.now());
        UserResponseDTO responseDto =  userService.createUser(userDTO);
        if (responseDto.getStatusCode() == 200 || responseDto.getStatusCode() == 201) {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setMessage(responseDto.getDescription());
            commonResponse.setData(responseDto);
            logger.info("UserController -> createUser() => ended");
            return new ResponseEntity<>(commonResponse, HttpStatus.OK);
        } else {
            commonResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            commonResponse.setMessage("Create User failed");
            commonResponse.setData(responseDto);
            logger.info("UserController -> create() => ended");
            return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get users request
     *
     * @return success or failed response from user and all users details
     * @author aathif
     */
    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        return userService.getUsers();
    }

    /**
     * Get user request
     *
     * @param id - required variable to get user
     * @return success or failed response from user and user details
     * @author aathif
     */
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id){
        return userService.getUserById(id);
    }

    /**
     * Update user request
     *
     * @param id - required variable to update a user
     * @param userDTO - required dto to update an user
     * @return success or failed response from user update and return updated user details
     * @author aathif
     */
    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@Valid @PathVariable("id") long id, @RequestBody UserDTO userDTO){
        return userService.updateUser(id, userDTO);
    }

    /**
     * Delete user request
     *
     * @param id - required variable to delete user
     * @return success or failed response from user
     * @author aathif
     */
    @DeleteMapping("/user/{id}")
    public ResponseEntity<CommonResponse> deleteUser(@PathVariable("id") long id){
        logger.info("UserController -> deleteUser() => start");
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setTimestamp(LocalDateTime.now());
        UserResponseDTO responseDto = userService.deleteUser(id);
        if (responseDto.getStatusCode() == 200) {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setMessage(responseDto.getDescription());
            commonResponse.setData(responseDto);
            logger.info("UserController -> deleteUser() => ended");
            return new ResponseEntity<>(commonResponse, HttpStatus.OK);
        } else {
            commonResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            commonResponse.setMessage("User initiation failed");
            commonResponse.setData(responseDto);
            logger.info("UserController -> delete() => ended");
            return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Delete users request
     *
     * @return success or failed response from user
     * @author aathif
     */
    @DeleteMapping("/users")
    public ResponseEntity<CommonResponse> deleteUsers(){
        logger.info("UserController -> deleteUsers() => start");
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setTimestamp(LocalDateTime.now());
        UserResponseDTO responseDto = userService.deleteUsers();
        if (responseDto.getStatusCode() == 200) {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setMessage(responseDto.getDescription());
            commonResponse.setData(responseDto);
            logger.info("UserController -> deleteUsers() => ended");
            return new ResponseEntity<>(commonResponse, HttpStatus.OK);
        } else {
            commonResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            commonResponse.setMessage("User initiation failed");
            commonResponse.setData(responseDto);
            logger.info("UserController -> deletes() => ended");
            return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
