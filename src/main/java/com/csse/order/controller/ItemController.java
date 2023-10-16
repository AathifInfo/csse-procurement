package com.csse.order.controller;

import com.csse.order.common.CommonResponse;
import com.csse.order.dto.ItemDTO;
import com.csse.order.dto.ItemResponseDTO;
import com.csse.order.entity.Item;
import com.csse.order.service.ItemService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ItemController {

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    ItemService itemService;

    /**
     * Create order request
     *
     * @param itemDTO - required dto to create an item
     * @return success or failed response from item creation and item details
     * @author Asiff
     */

    @PostMapping("/item")
    public ResponseEntity<CommonResponse> createItem(@Valid @RequestBody ItemDTO  itemDTO){
        logger.info("ItemController -> createItem() => start");
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setTimestamp(LocalDateTime.now());
        ItemResponseDTO responseDto =  itemService.createItem(itemDTO);
        if (responseDto.getStatusCode() == 200) {
            commonResponse.setStatus(HttpStatus.OK);
            commonResponse.setMessage(responseDto.getDescription());
            commonResponse.setData(responseDto);
            logger.info("ItemController -> createItem() => ended");
            return new ResponseEntity<>(commonResponse, HttpStatus.OK);
        } else {
            commonResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            commonResponse.setMessage("Create Item failed");
            commonResponse.setData(responseDto);
            logger.info("ItemController -> createItem() => ended");
            return new ResponseEntity<>(commonResponse, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Get items request
     *
     * @return success or failed response from all items details
     * @author Asiff
     */

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getOrders(){
        return itemService.getItems();
    }

}
