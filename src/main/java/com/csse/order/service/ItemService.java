package com.csse.order.service;

import com.csse.order.dto.ItemDTO;
import com.csse.order.dto.ItemResponseDTO;
import com.csse.order.dto.OrderResponseDTO;

public interface ItemService {

    ItemResponseDTO createItem(ItemDTO itemDTO);
}
