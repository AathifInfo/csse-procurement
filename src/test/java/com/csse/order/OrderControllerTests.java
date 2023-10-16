package com.csse.order;

import com.csse.order.entity.Order;
import com.csse.order.service.OrderService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
public class OrderControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Test
    public void testGetOrderById() throws Exception {
        Order order = new Order();
        order.setOrderId(1);
        order.setAddress("Colombo");

        // Define the behavior of the orderService mock
        Mockito.when(orderService.getOrderById(1));

        // Perform a GET request
        mockMvc.perform(MockMvcRequestBuilders.get("order/1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.address", Matchers.is("Colombo")));
    }

}
