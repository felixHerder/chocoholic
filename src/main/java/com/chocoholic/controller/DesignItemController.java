package com.chocoholic.controller;

import com.chocoholic.enums.IngredientType;
import com.chocoholic.model.Ingredient;
import com.chocoholic.model.Item;
import com.chocoholic.model.ItemOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("itemOrder")
public class DesignItemController {

    @ModelAttribute
    public void addIngredientsToItem(Model model) {
        List<Ingredient> ingredients = List.of(
                new Ingredient("WHTFLW", "White flower", IngredientType.FLOWER),
                new Ingredient("BRNFLW", "Brown flower", IngredientType.FLOWER),
                new Ingredient("DRKCHC", "Dark chocolate", IngredientType.FILLING),
                new Ingredient("MLKCHC", "Milk chocolate", IngredientType.FILLING),
                new Ingredient("GLZWHTCHC", "Glazed white chocolate", IngredientType.TOPPING),
                new Ingredient("RSN", "Raisins", IngredientType.TOPPING)
        );

        IngredientType[] types = IngredientType.values();
        for (IngredientType type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterIngredientsByType(type, ingredients));
        }
    }

//    @ModelAttribute(name = "itemOrder")
//    public ItemOrder order() {
//        return new ItemOrder();
//    }

//    @ModelAttribute(name = "item")
//    public Item item() {
//        return new Item();
//    }

    @GetMapping
    public String showDesignForm(){
        return "design";
    }

    private List<Ingredient> filterIngredientsByType(IngredientType type, List<Ingredient> ingredients) {
        return ingredients.stream().filter(i -> i.getType().equals(type)).toList();
    }
}
