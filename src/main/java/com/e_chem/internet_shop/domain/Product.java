package com.e_chem.internet_shop.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@ToString
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_seq")
    @SequenceGenerator(name = "products_seq", sequenceName = "products_seq", allocationSize = 1)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String description;
    private String image_link;
    private String brand;
}
