package com.csse.order;

import com.csse.order.entity.User;
import com.csse.order.service.UserService;
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
class UserControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testGetOrderById() throws Exception {
        User user = new User();
        user.setUserId(1);
        user.setUserName("Aathif");

        // Define the behavior of the userService mock
        Mockito.when(userService.getUserById(1));

        // Perform a GET request
        mockMvc.perform(MockMvcRequestBuilders.get("user/1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.userName", Matchers.is("Aathif")));
    }

}
