package com.csse.order.serviceimpl;

import com.csse.order.common.StatusCode;
import com.csse.order.dto.OrderDTO;
import com.csse.order.dto.OrderResponseDTO;
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
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceIMPL implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceIMPL.class);

    @Autowired
    OrderRepository orderRepository;

    /**
     * Create order request
     *
     * @param orderDTO - required dto to create an order
     * @return success or failed response from order creation and order details
     * @author aathif
     */
    @Override
    public OrderResponseDTO createOrder(OrderDTO orderDTO) {
        try {
            logger.error("OrderServiceIMPL -> createOrder() => started!");
            Order order = new Order(
                    orderDTO.getDate(),
                    orderDTO.getAddress(),
                    orderDTO.getSupplierDetails(),
                    orderDTO.getCompanyDetails(),
                    orderDTO.getQty()
            );
            orderRepository.save(order);
            logger.error("OrderServiceIMPL -> createOrder() => success!");
            return new OrderResponseDTO(StatusCode.OK, order, "Order Creation successfully", new Date());
        } catch (Exception e){
            logger.error("OrderServiceIMPL -> createOrder() => error: {}", e.getMessage());
            return new OrderResponseDTO(StatusCode.INTERNAL_SERVER_ERROR, null, "Order Creation failed", new Date());
        }
    }

    /**
     * Get orders request
     *
     * @return success or failed response from order and all orders details
     * @author aathif
     */
    @Override
    public ResponseEntity<List<Order>> getOrders() {
        try {
            logger.error("OrderServiceIMPL -> getOrders() => started!");
            List<Order> orderList = new ArrayList<>(orderRepository.findAll());

            if (orderList.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            logger.error("OrderServiceIMPL -> getOrders() => success!");
            return new ResponseEntity<>(orderList, HttpStatus.OK);
        } catch (Exception e){
            logger.error("OrderServiceIMPL -> getOrders() => error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get order request
     *
     * @param id - required variable to get order
     * @return success or failed response from order and order details
     * @author aathif
     */
    @Override
    public ResponseEntity<Order> getOrderById(long id) {
        try {
            logger.error("OrderServiceIMPL -> getOrderById() => started");
            Optional<Order> orderData = orderRepository.findById(id);

            if (orderData.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            logger.error("OrderServiceIMPL -> getOrderById() => success");
            return new ResponseEntity<>(orderData.get(), HttpStatus.OK);
        } catch (Exception e){
            logger.error("OrderServiceIMPL -> getOrderById() => error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Update order request
     *
     * @param id - required variable to update an order
     * @param orderDTO - required dto to update an order
     * @return success or failed response from order update and return updated order details
     * @author aathif
     */
    @Override
    public ResponseEntity<Order> updateOrder(long id, OrderDTO orderDTO) {
        try {
            logger.error("OrderServiceIMPL -> updateOrder() => started");
            Optional<Order> orderData = orderRepository.findById(id);
            if (orderData.isPresent()){
                logger.error("OrderServiceIMPL -> updateOrder() -> getOrderDetails()  => started");
                Order order = getOrderDetails(orderData, orderDTO);

                logger.error("OrderServiceIMPL -> updateOrder() => success");
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

            logger.error("OrderServiceIMPL -> updateOrder() -> getOrderDetails() => success");
            return order;
        }
        return null;
    }


    /**
     * Delete order request
     *
     * @param id - required variable to delete order
     * @return success or failed response from order
     * @author aathif
     */
    @Override
    public OrderResponseDTO deleteOrder(long id) {
        try {
            logger.error("OrderServiceIMPL -> deleteOrder() => started");
            orderRepository.deleteById(id);

            logger.error("OrderServiceIMPL -> deleteOrder() => success");
            return new OrderResponseDTO(StatusCode.OK, null, "Order delete successfully", new Date());
        } catch (Exception e){
            logger.error("OrderServiceIMPL -> deleteOrder() => error: {}", e.getMessage());
            return new OrderResponseDTO(StatusCode.INTERNAL_SERVER_ERROR, null, "Order delete failed", new Date());
        }
    }


    /**
     * Delete orders request
     *
     * @return success or failed response from order
     * @author aathif
     */
    @Override
    public OrderResponseDTO deleteOrders() {
        try {
            logger.error("OrderServiceIMPL -> deleteOrders() => started");
            orderRepository.deleteAll();

            logger.error("OrderServiceIMPL -> deleteOrders() => success");
            return new OrderResponseDTO(StatusCode.OK, null, "Delete all orders successfully", new Date());
        } catch (Exception e){
            logger.error("OrderServiceIMPL -> deleteOrders() => error: {}", e.getMessage());
            return new OrderResponseDTO(StatusCode.INTERNAL_SERVER_ERROR, null, "Delete all Orders failed", new Date());
        }
    }
}
