package com.chocoholic.service;

import com.chocoholic.model.Item;

public interface CatalogService {
    Iterable<Item> getItems();
}
