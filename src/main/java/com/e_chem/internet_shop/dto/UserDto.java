package com.e_chem.internet_shop.dto;

import com.e_chem.internet_shop.domain.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record UserDto (
        Long id,
        String firstName,
        String lastName,
        String password,
        String email,
        Role role
){
}
