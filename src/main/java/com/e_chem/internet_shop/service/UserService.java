package com.e_chem.internet_shop.service;

import com.e_chem.internet_shop.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsersList();

    Optional<User> findById (Long id);

    Optional<User> findByFirstName(String firstName);

    User save(User user);
}
