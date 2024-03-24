package com.e_chem.internet_shop.dto;

import com.e_chem.internet_shop.domain.Address;
import com.e_chem.internet_shop.domain.PhoneNumber;
import com.e_chem.internet_shop.domain.Role;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public record UserDto(
        String id,
        String firstName,
        String lastName,
//        String password,
        String email,
        Role role,
        Set<Address> address,
        List<PhoneNumber> phoneNumberList,
        LocalDateTime created) {
}
