package com.e_chem.internet_shop.controller;

import com.e_chem.internet_shop.domain.Product;
import com.e_chem.internet_shop.dto.ProductDto;
import com.e_chem.internet_shop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public ResponseEntity<Iterable<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Optional<Product> product = productService.getById(id);
        return product
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping()
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product product1 = productService.saveNewProduct(product);
        return ResponseEntity
                .created(URI.create("/products/)" + product1.getId()))
                .body(product1);
    }
}
