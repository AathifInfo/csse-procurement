package com.csse.order.serviceimpl;

import com.csse.order.common.StatusCode;
import com.csse.order.dto.UserDTO;
import com.csse.order.dto.UserResponseDTO;
import com.csse.order.entity.Order;
import com.csse.order.entity.User;
import com.csse.order.repository.UserRepository;
import com.csse.order.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceIMPL implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceIMPL.class);

    @Autowired
    UserRepository userRepository;

    /**
     * Create user request
     *
     * @param userDTO - required dto to create an user
     * @return success or failed response from user creation
     * @author aathif
     */
    @Override
    public UserResponseDTO createUser(UserDTO userDTO) {
        try {
            logger.error("UserServiceIMPL -> createUser() => started!");
            User user = new User(
                    userDTO.getUserName(),
                    userDTO.getUserEmail(),
                    userDTO.getPassword()
            );
            userRepository.save(user);
            logger.error("UserServiceIMPL -> createUser() => success!");
            return new UserResponseDTO(StatusCode.CREATED, user, "User Creation successfully", new Date());
        } catch (Exception e){
            logger.error("UserServiceIMPL -> createUser() => error: {}", e.getMessage());
            return new UserResponseDTO(StatusCode.INTERNAL_SERVER_ERROR, null, "User Creation failed", new Date());
        }
    }


    /**
     * Get users request
     *
     * @return success or failed response from user and all users details
     * @author aathif
     */
    @Override
    public ResponseEntity<List<User>> getUsers() {
        try {
            logger.error("UserServiceIMPL -> getUsers() => started!");
            List<User> userList = new ArrayList<>(userRepository.findAll());

            if (userList.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            logger.error("UserServiceIMPL -> getUsers() => success!");
            return new ResponseEntity<>(userList, HttpStatus.OK);
        } catch (Exception e){
            logger.error("UserServiceIMPL -> getUsers() => error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * Get user request
     *
     * @param id - required variable to get user
     * @return success or failed response from user and user details
     * @author aathif
     */
    @Override
    public ResponseEntity<User> getUserById(long id) {
        try {
            logger.error("UserServiceIMPL -> getUserById() => started");
            Optional<User> userData = userRepository.findById(id);

            if (userData.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            logger.error("UserServiceIMPL -> getUserById() => success");
            return new ResponseEntity<>(userData.get(), HttpStatus.OK);
        } catch (Exception e){
            logger.error("UserServiceIMPL -> getUserById() => error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
