package com.e_chem.internet_shop.service;

import com.e_chem.internet_shop.domain.Product;
import com.e_chem.internet_shop.dto.ProductDto;
import com.e_chem.internet_shop.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        return productRepository.save(product);
    }

    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    public Page<Product> findAllByPage(Pageable pageable) {
        return productRepository.findAll(PageRequest.of(pageable.getPageNumber(),pageable.getPageSize()));
    }

    public void delete (Long id){
        productRepository.deleteById(id);
    }
}
