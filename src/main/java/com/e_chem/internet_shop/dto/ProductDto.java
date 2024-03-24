package com.e_chem.internet_shop.dto;


public record ProductDto(
        Long id,
        String title,
        String description,
        String image_link,
        String brand) {
}
