package com.csse.order.serviceimpl;

import com.csse.order.common.StatusCode;
import com.csse.order.dto.OrderResponseDTO;
import com.csse.order.dto.PurchaseOrderDTO;
import com.csse.order.dto.PurchaseOrderResponseDTO;
import com.csse.order.entity.Order;
import com.csse.order.entity.PurchaseOrder;
import com.csse.order.repository.PurchaseOrderRepository;
import com.csse.order.service.PurchaseOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseOrderServiceIMPL implements PurchaseOrderService {

    private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderServiceIMPL.class);

    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    /**
     * Create order request
     *
     * @param purchaseOrderDTO - required dto to create an order
     * @return success or failed response from order creation and order details
     * @author aathif
     */

    @Override
    public PurchaseOrderResponseDTO createOrder(PurchaseOrderDTO purchaseOrderDTO) {
        try {
            logger.error("PurchaseOrderServiceIMPL -> createPurchaseOrder() => started!");
            PurchaseOrder purchaseOrder = new PurchaseOrder(
                    purchaseOrderDTO.getPurchaseOrderId(),
                    purchaseOrderDTO.getSupplierName(),
                    purchaseOrderDTO.getCompanyName(),
                    purchaseOrderDTO.getContactNo(),
                    purchaseOrderDTO.getTotalQty(),
                    purchaseOrderDTO.getPrice()
            );
            purchaseOrderRepository.save(purchaseOrder);
            logger.error("PurchaseOrderServiceIMPL -> createPurchaseOrder() => success!");
            return new PurchaseOrderResponseDTO(StatusCode.OK, purchaseOrder, "Purchase Order Creation successfully", new Date());
        } catch (Exception e){
            logger.error("PurchaseOrderServiceIMPL -> createPurchaseOrder() => error: {}", e.getMessage());
            return new PurchaseOrderResponseDTO(StatusCode.INTERNAL_SERVER_ERROR, null, "Purchase Order Creation failed", new Date());
        }
    }

    /**
     * Get purchase orders request
     *
     * @return success or failed response from all purchase orders details
     * @author Asiff
     */
    @Override
    public ResponseEntity<List<PurchaseOrder>> getPurchaseOrders() {
        try {
            logger.error("PurchaseOrderServiceIMPL -> getPurchaseOrder() => started!");
            List<PurchaseOrder> purchaseOrderList = new ArrayList<>(purchaseOrderRepository.findAll());

            if (purchaseOrderList.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            logger.error("PurchaseOrderServiceIMPL -> getPurchaseOrder() => success!");
            return new ResponseEntity<>(purchaseOrderList, HttpStatus.OK);
        } catch (Exception e){
            logger.error("PurchaseOrderServiceIMPL -> getPurchaseOrder() => error: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
