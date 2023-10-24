package com.csse.order.controller;

import com.csse.order.common.CommonResponse;
import com.csse.order.dto.OrderDTO;
import com.csse.order.dto.OrderResponseDTO;
import com.csse.order.dto.PurchaseOrderDTO;
import com.csse.order.dto.PurchaseOrderResponseDTO;
import com.csse.order.entity.Order;
import com.csse.order.entity.PurchaseOrder;
import com.csse.order.service.PurchaseOrderService;
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
public class PurchaseOrderController {
    private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderController.class);

    @Autowired
    PurchaseOrderService purchaseOrderService;

    /**
     * Create order request
     *
     * @param purchaseOrderDTO - required dto to create an order
     * @return success or failed response from order creation and order details
     * @author Asiff
     */

    @PostMapping("/purchaseOrder")
    public ResponseEntity<CommonResponse> createPurchaseOrder(@Valid @RequestBody PurchaseOrderDTO purchaseOrderDTO){
        logger.info("PurchaseOrderController -> createPurchaseOrder() => start");
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setTimestamp(LocalDateTime.now());
        PurchaseOrderResponseDTO responseDto =  purchaseOrderService.createOrder(purchaseOrderDTO);
        if (responseDto.getStatusCode() == 200) {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setMessage(responseDto.getDescription());
            commonResponse.setData(responseDto);
            logger.info("PurchaseOrderController -> createPurchaseOrder() => ended");
            return new ResponseEntity<>(commonResponse, HttpStatus.OK);
        } else {
            commonResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            commonResponse.setMessage("Create purchase order failed");
            commonResponse.setData(responseDto);
            logger.info("PurchaseOrderController -> createPurchaseOrder() => ended");
            return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get purchase orders request
     *
     * @return success or failed response from all purchase orders details
     * @author aathif
     */
    @GetMapping("/purchaseOrder")
    public ResponseEntity<List<PurchaseOrder>> getPurchaseOrders(){
        return purchaseOrderService.getPurchaseOrders();
    }
    
}
