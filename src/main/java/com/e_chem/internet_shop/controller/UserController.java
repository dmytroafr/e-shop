package com.e_chem.internet_shop.controller;

import com.e_chem.internet_shop.domain.User;
import com.e_chem.internet_shop.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profiles")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> userList (HttpServletRequest http){
        return ResponseEntity.ok(userService.getUsersList());


//        return userService.getUsersList();
    }
}
