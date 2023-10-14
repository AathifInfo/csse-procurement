package com.csse.order.controller;

import com.csse.order.dto.OrderDTO;
import com.csse.order.entity.Order;
import com.csse.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO){
        return orderService.createOrder(orderDTO);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getOrders(){
        return orderService.getOrders();
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") long id){
        return orderService.getOrderById(id);
    }

    @PutMapping("/order/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable("id") long id, @RequestBody OrderDTO orderDTO){
        return orderService.updateOrder(id, orderDTO);
    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("id") long id){
        return orderService.deleteOrder(id);
    }

    @DeleteMapping("/orders")
    public ResponseEntity<HttpStatus> deleteOrders(){
        return orderService.deleteOrders();
    }

}
