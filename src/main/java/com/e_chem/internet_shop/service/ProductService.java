package com.e_chem.internet_shop.service;

import com.e_chem.internet_shop.domain.Product;
import com.e_chem.internet_shop.dto.ProductDto;
import com.e_chem.internet_shop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getAllProducts() {
        List<Product> all = productRepository.findAll();
        return all.stream().map(product -> new ProductDto(
                product.getId(),
                product.getTitle(),
                product.getImage_link(),
                product.getDescription(),
                product.getBrand())).collect(Collectors.toList());
    }

    public Product saveNewProduct(Product product) {

//        Product product1 = new Product();
//        product1.setBrand(product.getBrand());
//        product1.setTitle(product.getTitle());
//        product1.setImage_link(product.getImage_link());
//        product1.setDescription(product.getDescription());
//        product1.setBrand(product.getBrand());

        return productRepository.save(product);
    }
}
