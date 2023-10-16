package com.csse.order.controller;

import com.csse.order.common.CommonResponse;
import com.csse.order.dto.OrderDTO;
import com.csse.order.dto.OrderResponseDTO;
import com.csse.order.entity.Order;
import com.csse.order.service.OrderService;
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
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderService orderService;

    /**
     * Create order request
     *
     * @param orderDTO - required dto to create an order
     * @return success or failed response from order creation and order details
     * @author aathif
     */
    @PostMapping("/order")
    public ResponseEntity<CommonResponse> createOrder(@Valid @RequestBody OrderDTO orderDTO){
        logger.info("OrderController -> createOrder() => start");
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setTimestamp(LocalDateTime.now());
        OrderResponseDTO responseDto =  orderService.createOrder(orderDTO);
        if (responseDto.getStatusCode() == 200 || responseDto.getStatusCode() == 201) {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setMessage(responseDto.getDescription());
            commonResponse.setData(responseDto);
            logger.info("OrderController -> createOrder() => ended");
            return new ResponseEntity<>(commonResponse, HttpStatus.OK);
        } else {
            commonResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            commonResponse.setMessage("Create order failed");
            commonResponse.setData(responseDto);
            logger.info("OrderController -> create() => ended");
            return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get orders request
     *
     * @return success or failed response from order and all orders details
     * @author aathif
     */
    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getOrders(){
        return orderService.getOrders();
    }


    /**
     * Get order request
     *
     * @param id - required variable to get order
     * @return success or failed response from order and order details
     * @author aathif
     */
    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") long id){
        return orderService.getOrderById(id);
    }


    /**
     * Update order request
     *
     * @param id - required variable to update an order
     * @param orderDTO - required dto to update an order
     * @return success or failed response from order update and return updated order details
     * @author aathif
     */
    @PutMapping("/order/{id}")
    public ResponseEntity<Order> updateOrder(@Valid @PathVariable("id") long id, @RequestBody OrderDTO orderDTO){
        return orderService.updateOrder(id, orderDTO);
    }


    /**
     * Delete order request
     *
     * @param id - required variable to delete order
     * @return success or failed response from order
     * @author aathif
     */
    @DeleteMapping("/order/{id}")
    public ResponseEntity<CommonResponse> deleteOrder(@PathVariable("id") long id){
        logger.info("OrderController -> deleteOrder() => start");
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setTimestamp(LocalDateTime.now());
        OrderResponseDTO responseDto = orderService.deleteOrder(id);
        if (responseDto.getStatusCode() == 200) {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setMessage(responseDto.getDescription());
            commonResponse.setData(responseDto);
            logger.info("OrderController -> deleteOrder() => ended");
            return new ResponseEntity<>(commonResponse, HttpStatus.OK);
        } else {
            commonResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            commonResponse.setMessage("Claim initiation failed");
            commonResponse.setData(responseDto);
            logger.info("OrderController -> delete() => ended");
            return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Delete orders request
     *
     * @return success or failed response from order
     * @author aathif
     */
    @DeleteMapping("/orders")
    public ResponseEntity<CommonResponse> deleteOrders(){
        logger.info("OrderController -> createOrder() => start");
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setTimestamp(LocalDateTime.now());
        OrderResponseDTO responseDto = orderService.deleteOrders();
        if (responseDto.getStatusCode() == 200) {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setMessage(responseDto.getDescription());
            commonResponse.setData(responseDto);
            logger.info("OrderController -> deleteOrders() => ended");
            return new ResponseEntity<>(commonResponse, HttpStatus.OK);
        } else {
            commonResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            commonResponse.setMessage("Claim initiation failed");
            commonResponse.setData(responseDto);
            logger.info("ClaimController -> deletes() => ended");
            return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
