package com.e_chem.internet_shop.controller;

import com.e_chem.internet_shop.domain.Product;
import com.e_chem.internet_shop.dto.ProductDto;
import com.e_chem.internet_shop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public List<ProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product product1 = productService.saveNewProduct(product);
        return ResponseEntity.ok(product1);
    }
}
