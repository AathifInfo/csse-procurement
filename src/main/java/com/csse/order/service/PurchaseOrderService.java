package com.csse.order.service;

import com.csse.order.dto.PurchaseOrderDTO;
import com.csse.order.dto.PurchaseOrderResponseDTO;
import com.csse.order.entity.PurchaseOrder;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PurchaseOrderService {
    PurchaseOrderResponseDTO createOrder(PurchaseOrderDTO purchaseOrderDTO);

    ResponseEntity<List<PurchaseOrder>> getPurchaseOrders();
}
