package com.chocoholic.service;


import com.chocoholic.model.Item;
import com.chocoholic.model.ItemEntity;
import com.chocoholic.repository.ItemRepository;
import com.chocoholic.service.JpaCatalogService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.math.BigDecimal;

@DataJpaTest
class JpaCatalogServiceTest {
    @Autowired
    TestEntityManager testEntityManager;

    @Autowired
    ItemRepository itemRepository;

    private JpaCatalogService jpaCatalogService;

    @BeforeEach
    void setup() {
        this.jpaCatalogService = new JpaCatalogService(this.itemRepository);
    }

    @Test
    @DisplayName("returns data from the database")
    void returnsDataFromDatabase() {
        String expectedTitle = "Victoria Sponge";
        saveTestItem(expectedTitle, BigDecimal.valueOf(5.55));

        Iterable<Item> items = jpaCatalogService.getItems();
        Assertions.assertThat(items).anyMatch(item-> expectedTitle.equals(item.getTitle()));
    }

    private void saveTestItem(String title, BigDecimal price){
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setUuid("test-item-1");
        itemEntity.setTitle(title);
        itemEntity.setPrice(price);

        testEntityManager.persistAndFlush(itemEntity);
    }
}
