package com.chocoholic.service;

import com.chocoholic.model.Item;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

public class InMemoryCatalogService implements CatalogService {
    @Override
    public Iterable<Item> getItems() {
        return List.of(
                new Item("Test item 1", BigDecimal.valueOf(2.43)),
                new Item("Test item 2", BigDecimal.valueOf(1.23)),
                new Item("Test item 3", BigDecimal.valueOf(7.23))
        );
    }
}
