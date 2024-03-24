package com.e_chem.internet_shop.controller;

import com.e_chem.internet_shop.domain.User;
import com.e_chem.internet_shop.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getUserList(){
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userService.getUsersList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById (@PathVariable Long id){
        Optional<User> byId = userService.findById(id);
        return ResponseEntity.ok(byId.orElseThrow());
    }

    @GetMapping("/my")
    public ResponseEntity<User> getPrincipalInf (Principal principal){
        String name = principal.getName();
        Optional<User> optionalUser = userService.findByFirstName(name);
        if (optionalUser.isEmpty()){
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new User());
        }
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userService.findByFirstName(name).get());
    }

    @PostMapping("/new")
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucb){
        User newUser = userService.createNewUser(user);
        URI location = ucb
                .path("/users/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();
        return ResponseEntity.created(location)
                .build();
    }


}
