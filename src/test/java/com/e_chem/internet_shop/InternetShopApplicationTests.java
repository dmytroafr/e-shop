package com.e_chem.internet_shop;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InternetShopApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    @Order(1)
    void returnMain() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("/",String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    @Test
    @Order(2)
    void returnProduct() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("/products/1",String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
    @Test
    @Order(3)
    void returnProducts() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("/products",String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


}
