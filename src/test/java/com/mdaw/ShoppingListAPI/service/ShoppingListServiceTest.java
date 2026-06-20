package com.mdaw.ShoppingListAPI.service;

import com.mdaw.ShoppingListAPI.config.StoreProperties;
import com.mdaw.ShoppingListAPI.model.Item;
import com.mdaw.ShoppingListAPI.model.ShoppingListRequest;
import com.mdaw.ShoppingListAPI.model.ShoppingListResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ShoppingListServiceTest {

    @Autowired
    private ShoppingListService service;

    @Autowired
    private StoreProperties storeProperties;

    @Test
    public void testCalculateRoute() {

        System.out.println("Store properties items: " + storeProperties.getItems());

        List<String> items = List.of("MILK","Fage","BrEaD", "SalmON", "teaCAKES", "TooThPASTe");
        ShoppingListRequest input = new ShoppingListRequest(items);

        ShoppingListResponse result = service.orderShoppingList(input);

        assertEquals("MILK", result.getorderedItems().get(0).getName());
        assertEquals(2, result.getorderedItems().get(0).getAisle());
        assertEquals("FAGE", result.getorderedItems().get(1).getName());
        assertEquals(3, result.getorderedItems().get(1).getAisle());
        assertEquals("SALMON", result.getorderedItems().get(2).getName());
        assertEquals(4, result.getorderedItems().get(2).getAisle());
        assertEquals("TOOTHPASTE", result.getorderedItems().get(3).getName());
        assertEquals(10, result.getorderedItems().get(3).getAisle());
        assertEquals("TEACAKES", result.getorderedItems().get(4).getName());
        assertEquals(17, result.getorderedItems().get(4).getAisle());
        assertEquals("BREAD", result.getorderedItems().get(5).getName());
        assertEquals(23, result.getorderedItems().get(5).getAisle());

    }


    @Test
    public void unknownItem() {
        List<String> items = List.of("MIKL","FDRAGE","BrEaD", "SalmON", "TUNNOCKS TEACAKES", "TooThPASTe");
        ShoppingListRequest input = new ShoppingListRequest(items);

        ShoppingListResponse result = service.orderShoppingList(input);

        assertEquals("SALMON", result.getorderedItems().get(0).getName());
        assertEquals(4, result.getorderedItems().get(0).getAisle());
        assertEquals("TOOTHPASTE", result.getorderedItems().get(1).getName());
        assertEquals(10, result.getorderedItems().get(1).getAisle());
        assertEquals("BREAD", result.getorderedItems().get(2).getName());
        assertEquals(23, result.getorderedItems().get(2).getAisle());

        //milk, fage, teacakes
        assertTrue(listContains("MIKL", result.getorderedItems()));
        assertTrue(listContains("FDRAGE", result.getorderedItems()));
        assertTrue(listContains("TUNNOCKS TEACAKES", result.getorderedItems()));
    }

    private boolean listContains(String searchValue, List<Item> items) {
        return items.stream().anyMatch(item -> item.getName().equals(searchValue));
    }


}


