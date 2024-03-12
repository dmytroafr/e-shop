package com.e_chem.internet_shop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class PhoneNumber {
    @Column(nullable = false)
    private String phone1;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;
    enum Type{
        HOME, MOBILE, OFFICE
    }


}