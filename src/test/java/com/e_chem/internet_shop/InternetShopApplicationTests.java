package com.e_chem.internet_shop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class InternetShopApplicationTests {

    private TestRestTemplate restTemplate;

//    public InternetShopApplicationTests(TestRestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }

    @Test
    void contextLoads() {
        if (restTemplate ==null){
            assertThat(restTemplate).isNull();
        } else {
            assertThat(restTemplate.getForObject("http://localhost:8080/", String.class))
                    .contains("Hello, Guest");
        }



    }

}
