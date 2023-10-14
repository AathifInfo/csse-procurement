package com.csse.order.serviceimpl;

import com.csse.order.dto.OrderDTO;
import com.csse.order.entity.Order;
import com.csse.order.repository.OrderRepository;
import com.csse.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceIMPL implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceIMPL.class);

    @Autowired
    OrderRepository orderRepository;

    @Override
    public ResponseEntity<Order> createOrder(OrderDTO orderDTO) {
        try {
            logger.error("OrderServiceIMPL -> createOrder() => started");
            Order order = new Order(
                    orderDTO.getDate(),
                    orderDTO.getAddress(),
                    orderDTO.getSupplierDetails(),
                    orderDTO.getCompanyDetails(),
                    orderDTO.getQty()
            );
            orderRepository.save(order);
            logger.error("OrderServiceIMPL -> createOrder() => success");
            return new ResponseEntity<>(order, HttpStatus.CREATED);
        } catch (Exception e){
            logger.error("OrderServiceIMPL -> createOrder() => error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Order>> getOrders() {
        try {
            logger.error("OrderServiceIMPL -> getOrders() => started");
            List<Order> orderList = new ArrayList<>(orderRepository.findAll());

            if (orderList.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            logger.error("OrderServiceIMPL -> getOrders() => ended");
            return new ResponseEntity<>(orderList, HttpStatus.OK);
        } catch (Exception e){
            logger.error("OrderServiceIMPL -> getOrders() => error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Order> getOrderById(long id) {
        try {
            logger.error("OrderServiceIMPL -> getOrderById() => started");
            Optional<Order> orderData = orderRepository.findById(id);

            if (orderData.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            logger.error("OrderServiceIMPL -> getOrderById() => ended");
            return new ResponseEntity<>(orderData.get(), HttpStatus.OK);
        } catch (Exception e){
            logger.error("OrderServiceIMPL -> getOrderById() => error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Order> updateOrder(long id, OrderDTO orderDTO) {
        try {
            logger.error("OrderServiceIMPL -> updateOrder() => started");
            Optional<Order> orderData = orderRepository.findById(id);
            if (orderData.isPresent()){
                logger.error("OrderServiceIMPL -> updateOrder() -> getOrderDetails()  => started");
                Order order = getOrderDetails(orderData, orderDTO);

                logger.error("OrderServiceIMPL -> updateOrder() => ended");
                return new ResponseEntity<>(orderRepository.save(order), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            logger.error("OrderServiceIMPL -> updateOrder() => error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private Order getOrderDetails(Optional<Order> orderData, OrderDTO orderDTO) {
        if (orderData.isPresent()){
            Order order = orderData.get();
            order.setDate(orderDTO.getDate());
            order.setAddress(orderDTO.getAddress());
            order.setSupplierDetails(orderDTO.getSupplierDetails());
            order.setCompanyDetails(orderDTO.getCompanyDetails());
            order.setQty(orderDTO.getQty());

            logger.error("OrderServiceIMPL -> updateOrder() -> getOrderDetails() => ended");
            return order;
        }
        return null;
    }

    @Override
    public ResponseEntity<HttpStatus> deleteOrder(long id) {
        try {
            logger.error("OrderServiceIMPL -> deleteOrder() => started");
            orderRepository.deleteById(id);

            logger.error("OrderServiceIMPL -> deleteOrder() => ended");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            logger.error("OrderServiceIMPL -> deleteOrder() => error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteOrders() {
        try {
            logger.error("OrderServiceIMPL -> deleteOrders() => started");
            orderRepository.deleteAll();

            logger.error("OrderServiceIMPL -> deleteOrders() => ended");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            logger.error("OrderServiceIMPL -> deleteOrders() => error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
