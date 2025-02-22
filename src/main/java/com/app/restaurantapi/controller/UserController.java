package com.app.restaurantapi.controller;

import com.app.restaurantapi.entity.User;
import com.app.restaurantapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/restaurante")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam String name, @RequestParam String password) {
        User user = userService.validateUser(name, password);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.status(401).build();
    }
}
