package com.e_chem.internet_shop.controller;

import com.e_chem.internet_shop.domain.Product;
import com.e_chem.internet_shop.dto.ProductDto;
import com.e_chem.internet_shop.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductDto> getAllProducts(){
        return productRepository.findAllBy();
    }

    @PostMapping
    public void addProduct(@RequestBody Product product){
        productRepository.save(product);
    }
}
