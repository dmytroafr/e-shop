package com.e_chem.internet_shop;

import com.e_chem.internet_shop.domain.Product;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    @Order(1)
    void returnProductById() {
        ResponseEntity<Product> responseEntity = restTemplate.getForEntity("/products/1",Product.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isNotNull();
        assertThat(responseEntity.getBody().getId()).isEqualTo(1);
    }
    @Test
    @Order(2)
    void shouldReturnNothingForUnknownId(){
        ResponseEntity<Product> response = restTemplate.getForEntity("/products/1000", Product.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).isNull();
    }
    @Test
    @Order(3)
    void returnProducts() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("/products",String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }




}
