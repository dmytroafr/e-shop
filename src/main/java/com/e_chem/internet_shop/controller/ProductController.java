package com.e_chem.internet_shop.controller;

import com.e_chem.internet_shop.domain.Product;
import com.e_chem.internet_shop.service.ProductService;
import com.e_chem.internet_shop.service.ProductServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }
//    @GetMapping
//    public ResponseEntity<List<ProductDto>> getAllProducts(){
//        return ResponseEntity.ok(productService.getAllProducts());
//    }
    @GetMapping
    public ResponseEntity<List<Product>> findAllByPage(Pageable pageable){
        Page<Product> page = productService.findAllByPage(pageable);
        return ResponseEntity.ok(page.getContent());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Optional<Product> product = productService.getById(id);
        return product
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping()
    public ResponseEntity<Void> addProduct(@RequestBody Product product, UriComponentsBuilder ucb) {
        Product savedProduct = productService.saveNewProduct(product);
        URI location = ucb
                .path("/products/{id}")
                .buildAndExpand(savedProduct.getId())
                .toUri();
        return ResponseEntity
                .created(location)
                .build();
    }
    @PutMapping("/{requestedId}")
    public ResponseEntity<Void> putProduct (@PathVariable Long requestedId, @RequestBody Product product){
        Optional<Product> byId = productService.getById(requestedId);
        if (byId.isPresent()){
            Product productFromDB = byId.get();
            product.setId(productFromDB.getId());
            productService.saveNewProduct(product);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct (@PathVariable Long id){
        Optional<Product> byId = productService.getById(id);
        if (byId.isPresent()){
            productService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }
}
