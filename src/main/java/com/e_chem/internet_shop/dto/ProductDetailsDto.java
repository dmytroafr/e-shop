package com.e_chem.internet_shop.dto;

import com.e_chem.internet_shop.domain.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.math.BigDecimal;
@Embeddable
public record ProductDetailsDto(
        @OneToOne
        @JoinColumn(name = "products_id")
        Product product,
        Integer amount,
        BigDecimal price
) {

    public BigDecimal getSum(){
        return price.multiply(BigDecimal.valueOf(amount));
    }


}
