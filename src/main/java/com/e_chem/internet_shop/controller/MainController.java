package com.e_chem.internet_shop.controller;

import com.e_chem.internet_shop.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"", "/"})
public class MainController {

    UserRepository userRepository;

    public MainController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping({"/","","/{name}"})
    @ResponseBody
    public String hello(@PathVariable(required = false) String name){
        String defaultName = "Guest";
        if (name!=null) {
            defaultName = name;
        }
        return "Hello, " + defaultName;
    }



}
