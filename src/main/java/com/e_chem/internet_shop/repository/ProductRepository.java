package com.e_chem.internet_shop.repository;

import com.e_chem.internet_shop.domain.Product;
import com.e_chem.internet_shop.dto.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
