package com.e_chem.internet_shop.domain;

import com.e_chem.internet_shop.dto.ProductDetailsDto;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_seq")
    @SequenceGenerator(name = "orders_seq", sequenceName = "orders_seq",allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;
    @ElementCollection
    private List<ProductDetailsDto> productDetails;
    @Enumerated(EnumType.STRING)
    private Payment payment;
    @Enumerated(EnumType.STRING)
    private Delivery delivery;
    @Enumerated(EnumType.STRING)
    private Status status;
    private final LocalDateTime created = LocalDateTime.now();
}
