package com.csse.order.serviceimpl;

import com.csse.order.common.StatusCode;
import com.csse.order.controller.ItemController;
import com.csse.order.dto.ItemDTO;
import com.csse.order.dto.ItemResponseDTO;
import com.csse.order.entity.Item;
import com.csse.order.repository.ItemRepository;
import com.csse.order.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ItemServiceIMPL implements ItemService {

    private static final Logger logger = LoggerFactory.getLogger(ItemServiceIMPL.class);

    @Autowired
    ItemRepository itemRepository;

    /**
     * Create order request
     *
     * @param itemDTO - required dto to create an item
     * @return success or failed response from item creation and item details
     * @author Asiff
     */

    @Override
    public ItemResponseDTO createItem(ItemDTO itemDTO) {
        try {
            logger.error("ItemServiceIMPL -> createOrder() => started!");
            Item item = new Item(
                    itemDTO.getItemName(),
                    itemDTO.getQty(),
                    itemDTO.getPrice()
            );
            itemRepository.save(item);
            logger.error("ItemServiceIMPL -> createOrder() => success!");
            return new ItemResponseDTO(StatusCode.CREATED, item, "Item Creation successfully", new Date());
        } catch (Exception e){
            logger.error("ItemServiceIMPL -> createItem() => started");
            return new ItemResponseDTO(StatusCode.INTERNAL_SERVER_ERROR, null , "Item Creation Failed", new Date());
        }
    }
}
