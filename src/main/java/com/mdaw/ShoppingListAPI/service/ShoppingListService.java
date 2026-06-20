package com.mdaw.ShoppingListAPI.service;

import com.mdaw.ShoppingListAPI.config.StoreProperties;
import com.mdaw.ShoppingListAPI.model.Item;
import com.mdaw.ShoppingListAPI.model.ShoppingListRequest;
import com.mdaw.ShoppingListAPI.model.ShoppingListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShoppingListService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingListService.class);
    private final Map<String, Integer> itemAisleMap;

    public ShoppingListService(StoreProperties storeProperties) {
        this.itemAisleMap = storeProperties.getItems();
    }

    public ShoppingListResponse orderShoppingList(ShoppingListRequest request) {

        LOGGER.info("Received shopping list: {}", request);
        List<Item> items = new ArrayList<>();

        for (String name : request.getItems()) {
            Integer aisle = itemAisleMap.get(name.toLowerCase());

            if (aisle == null) {
                LOGGER.info("Item %s is not available".formatted(name));
                items.add(new Item(name.toUpperCase(), -1));
            } else {
                items.add(new Item(name.toUpperCase(), aisle));
            }
        }

        List<Item> orderedItems = calculateRoute(items);

        return new ShoppingListResponse(orderedItems);
    }

    private List<Item> calculateRoute(List<Item> items) {

        List<Item> route = new ArrayList<>();

        int currentPosition = 0;

        List<Item> unvisited = new ArrayList<>(items);

        //while unvisited has items

        while (!unvisited.isEmpty()) {

            final int currentPos = currentPosition;

            Item nearest = unvisited.stream()
                    .min(Comparator.comparingInt(item -> {
                        int aisle = item.getAisle();
                        return (aisle < 0) ? Integer.MAX_VALUE : Math.abs(aisle - currentPos);
                    }))
                    .orElseThrow();

            route.add(nearest);

            if (nearest.getAisle() >= 0) {
                currentPosition = nearest.getAisle();
            }

            unvisited.remove(nearest);
        }

        return route;
    }

}
