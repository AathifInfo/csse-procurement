package com.csse.order.service;

import com.csse.order.dto.ItemDTO;
import com.csse.order.dto.ItemResponseDTO;
import com.csse.order.dto.OrderResponseDTO;
import com.csse.order.entity.Item;
import com.csse.order.entity.Order;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ItemService {

    ItemResponseDTO createItem(ItemDTO itemDTO);

    ResponseEntity<List<Item>> getItems();
}
