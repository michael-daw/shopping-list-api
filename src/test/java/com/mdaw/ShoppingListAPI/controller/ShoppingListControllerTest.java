package com.mdaw.ShoppingListAPI.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mdaw.ShoppingListAPI.model.ShoppingListRequest;
import com.mdaw.ShoppingListAPI.service.ShoppingListService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

public class ShoppingListControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private ShoppingListService shoppingListService;

    @Test
    public void testOrderShoppingListEndpoint() throws Exception {
        ShoppingListRequest request = new ShoppingListRequest(Arrays.asList("milk", "eggs", "coffee", "tea"));



    }


}
