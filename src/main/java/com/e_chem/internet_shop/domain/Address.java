package com.e_chem.internet_shop.domain;

import jakarta.persistence.*;

@Embeddable
public class Address {
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String building;
    private String apt;
    @Column(nullable = false)
    private Integer zip;
}
