package com.csse.order.service;

import com.csse.order.dto.OrderDTO;
import com.csse.order.dto.OrderResponseDTO;
import com.csse.order.entity.Order;
import org.springframework.http.ResponseEntity;
import java.util.List;


public interface OrderService {
    OrderResponseDTO createOrder(OrderDTO orderDTO);

    ResponseEntity<List<Order>> getOrders();

    ResponseEntity<Order> getOrderById(long id);

    ResponseEntity<Order> updateOrder(long id, OrderDTO orderDTO);

    OrderResponseDTO deleteOrder(long id);

    OrderResponseDTO deleteOrders();
}
