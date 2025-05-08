package com.chocoholic.service;

import com.chocoholic.model.Item;
import com.chocoholic.model.ItemEntity;
import com.chocoholic.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@RequiredArgsConstructor
public class JpaCatalogService implements CatalogService {

    private final ItemRepository itemRepository;

    @Override
    public Iterable<Item> getItems() {
        return StreamSupport
                .stream(itemRepository.findAll().spliterator(), false)
                .map(this::mapItemEntityToItem)
                .collect(Collectors.toList());
    }

    private Item mapItemEntityToItem(ItemEntity itemEntity) {
        return new Item(itemEntity.getTitle(), itemEntity.getPrice());
    }
}
