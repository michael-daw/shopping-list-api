package com.mdaw.ShoppingListAPI.controller;


import com.mdaw.ShoppingListAPI.model.ShoppingListRequest;
import com.mdaw.ShoppingListAPI.model.ShoppingListResponse;
import com.mdaw.ShoppingListAPI.service.ShoppingListService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ShoppingListController {

    private final ShoppingListService shoppingListService;

    @Autowired
    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }

    @Operation(
            summary = "Reorder Shopping List",
            description = "Accepts a list of shopping items and return them ordered by aisle based on a nearest neighbour route algorithm"
    )

    @PostMapping("/order-shopping-list")
    public ResponseEntity<ShoppingListResponse> orderShoppingList(@RequestBody ShoppingListRequest request) {
        ShoppingListResponse response = shoppingListService.orderShoppingList(request);

        return ResponseEntity.ok(response);
    }
}
