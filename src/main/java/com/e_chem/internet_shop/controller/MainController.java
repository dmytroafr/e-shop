package com.e_chem.internet_shop.controller;

import com.e_chem.internet_shop.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"", "/"})
public class MainController {

    UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping({"/","","/{name}"})
    public ResponseEntity<String> hello(@PathVariable(required = false) String name){
        String defaultName = "Guest";
        if (name!=null) {
            defaultName = name;
        }
        String out = "Hello, " + defaultName;
        return ResponseEntity.ok(out);
    }

}
