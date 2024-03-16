package com.e_chem.internet_shop.service;

import com.e_chem.internet_shop.domain.User;
import com.e_chem.internet_shop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getDetails() {
        return userRepository.findAll();
    }
}
