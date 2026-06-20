package com.mdaw.ShoppingListAPI.model;

import java.util.List;

public class ShoppingListResponse {

    private List<Item> orderedItems;

    public ShoppingListResponse(List<Item> orderedItems) {
        this.orderedItems = orderedItems;
    }

    public List<Item> getorderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<Item> orderedItems) {
        this.orderedItems = orderedItems;
    }
}
