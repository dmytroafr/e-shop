package com.e_chem.internet_shop;

import com.e_chem.internet_shop.controller.ProductController;
import com.e_chem.internet_shop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class ProductControllerTest {
    @Mock
    ProductService productService;
    @InjectMocks
    ProductController productController;

    private MockMvc mockMvc;
    @BeforeEach
    void setUp (){
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }
    @Test
    void getRequestOnProducts() throws Exception {
        mockMvc.perform(get("/products")).andExpect(status().isOk());
    }




}
