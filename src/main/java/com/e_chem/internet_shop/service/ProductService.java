package com.e_chem.internet_shop.service;

import com.e_chem.internet_shop.domain.Product;
import com.e_chem.internet_shop.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDto> getAllProducts();
    Product saveNewProduct(Product product);

    Optional<Product> getById(Long id);

    Page<Product> findAllByPage(Pageable pageable);

    void delete (Long id);
}
