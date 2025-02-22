package com.app.restaurantapi.service;

import com.app.restaurantapi.entity.User;
import com.app.restaurantapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User validateUser(String name, String password) {
        return userRepository.validateUser(name, password);
    }
}
