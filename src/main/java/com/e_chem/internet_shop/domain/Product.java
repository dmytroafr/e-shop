package com.e_chem.internet_shop.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String unit;

    @Column(nullable = false)
    private String photoUrl;

    @Column(nullable = false)
    private String producer;

    @Column(nullable = false)
    private String countryOrigin;
}
