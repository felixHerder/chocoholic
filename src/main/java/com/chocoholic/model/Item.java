package com.chocoholic.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Item {
    private String title;
    private BigDecimal price;
    private List<Ingredient> ingredients;
}
