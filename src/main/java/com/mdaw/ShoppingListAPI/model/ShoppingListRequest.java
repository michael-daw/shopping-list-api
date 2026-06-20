package com.mdaw.ShoppingListAPI.model;

import java.util.List;

public class ShoppingListRequest {

    private List<String> items;

    public ShoppingListRequest(List<String> items) {
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }
}
