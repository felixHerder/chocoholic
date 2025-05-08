package com.chocoholic.controller;

import com.chocoholic.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class CatalogController {
    private final CatalogService catalogService;

    @GetMapping("/")
    public ModelAndView showCatalog() {
        return new ModelAndView("catalog", Map.of("items", this.catalogService.getItems()));
    }
}
