package com.chocoholic.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ItemOrder {

    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }
}
