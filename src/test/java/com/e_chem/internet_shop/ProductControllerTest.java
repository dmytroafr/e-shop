package com.e_chem.internet_shop;

import com.e_chem.internet_shop.domain.Product;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;


import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ProductControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    @Order(1)
    void returnProductById() {
        ResponseEntity<Product> responseEntity = restTemplate
                .withBasicAuth("admin","admin")
                .getForEntity("/products/1",Product.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isNotNull();
        assertThat(responseEntity.getBody().getId()).isEqualTo(1);
    }
    @Test
    @Order(2)
    void shouldReturnNothingForUnknownId(){
        ResponseEntity<Product> response = restTemplate
                .withBasicAuth("admin","admin")
                .getForEntity("/products/1000", Product.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).isNull();
    }
    @Test
    @Order(3)
    void returnProducts() {
        ResponseEntity<String> responseEntity = restTemplate
                .withBasicAuth("admin","admin")
                .getForEntity("/products",String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
//    @DirtiesContext
    @Test
    @Order(4)
    void createProductTest(){
        Product newOne = new Product();
        newOne.setTitle("TestProduct");
        ResponseEntity<Void> response = restTemplate
                .withBasicAuth("admin","admin")
                .postForEntity("/products", newOne, Void.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        URI location = response.getHeaders().getLocation();
        ResponseEntity<String> responseEntity = restTemplate
                .withBasicAuth("admin","admin")
                .getForEntity(location,String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(responseEntity.getBody());
        Number productId = documentContext.read("$.id");
        assertThat(productId).isNotNull();
    }




}
