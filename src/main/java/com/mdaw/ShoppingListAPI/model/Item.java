package com.mdaw.ShoppingListAPI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
public class Item {

    private String name;
    private int aisle;
    private OffsetDateTime useByDate;

}
