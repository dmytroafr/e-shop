package com.e_chem.internet_shop.controller;

import com.e_chem.internet_shop.domain.User;
import com.e_chem.internet_shop.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

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
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userService.findByFirstName(name).orElseThrow());
    }

    @PostMapping("/new")
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucb){
        User newUser = userService.save(user);
        URI location = ucb
                .path("/users/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();
        return ResponseEntity.created(location)
                .build();
    }

    @PutMapping("/{requestedId}")
    public ResponseEntity<Void> putUser (@PathVariable Long requestedId, @RequestBody User user){
        Optional<User> byId = userService.findById(requestedId);
        if (byId.isPresent()){
            User user1 = byId.get();

            user.setId(user1.getId());
//            user1.setLastName(user.getLastName());
//   how to merge entities

            userService.save(user);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
