package com.e_chem.internet_shop.dto;

public record ProductDto(Long id,
                         String title,
                         String unit,
                         String photoUrl,
                         String producer,
                         String countryOrigin) {
}
