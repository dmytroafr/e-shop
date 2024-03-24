package com.e_chem.internet_shop.repository;

import com.e_chem.internet_shop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
