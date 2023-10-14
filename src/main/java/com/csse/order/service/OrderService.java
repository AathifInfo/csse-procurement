package com.csse.order.service;

import com.csse.order.dto.OrderDTO;
import com.csse.order.entity.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;


public interface OrderService {
    ResponseEntity<Order> createOrder(OrderDTO orderDTO);

    ResponseEntity<List<Order>> getOrders();

    ResponseEntity<Order> getOrderById(long id);

    ResponseEntity<Order> updateOrder(long id, OrderDTO orderDTO);

    ResponseEntity<HttpStatus> deleteOrder(long id);

    ResponseEntity<HttpStatus> deleteOrders();
}
