package com.chocoholic;

import com.chocoholic.model.Item;
import com.chocoholic.service.CatalogService;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@SpringBootTest
@AutoConfigureMockMvc
class CatalogControllerTest {
    private WebClient webClient;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CatalogService catalogService;

    @BeforeEach
    void setUp() {
        this.webClient = MockMvcWebClientBuilder.mockMvcSetup(mockMvc).build();
    }

    @Test
    @DisplayName("index page returns the landing page")
    void returnsLandingPage() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Chocoholic Pastries")));
    }

    @Test
    @DisplayName("index page returns a list of items from the database")
    void returnListOfItemsFromDb() throws Exception {
        final String expectedTitle = "Sugar donut";
        mockItems(expectedTitle, BigDecimal.valueOf(42));

        HtmlPage page = this.webClient.getPage("http://localhost/");

        assertThat(page.querySelectorAll(".item-title"))
                .anyMatch(domNode -> expectedTitle.equals(domNode.asNormalizedText()));

    }

    private void mockItems(String title, BigDecimal price) {
        when(catalogService.getItems()).thenReturn(Collections.singletonList(new Item(title, price)));
    }
}
