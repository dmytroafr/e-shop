package com.e_chem.internet_shop.controller;

import com.e_chem.internet_shop.domain.User;
import com.e_chem.internet_shop.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class MainController {

    UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/users")
    public List<User> userList (){
        return userRepository.findAll();
    }


}
