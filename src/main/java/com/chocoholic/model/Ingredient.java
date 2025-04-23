package com.chocoholic.model;

import com.chocoholic.enums.IngredientType;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class Ingredient {
    private final String id;
    private final String name;
    private BigDecimal price;
    private final IngredientType type;
}
