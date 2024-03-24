package com.e_chem.internet_shop.domain;

import com.e_chem.internet_shop.dto.ProductDetailsDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Entity
@Table(name = "buckets")
@Data
public class Bucket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "buckets_seq")
    @SequenceGenerator(name = "buckets_seq", sequenceName = "buckets_seq", allocationSize = 1)
    private Long id;
    @OneToOne
    @JoinColumn(name = "users_id")
    private User user;
    @ElementCollection
    List<ProductDetailsDto> productList;
}
