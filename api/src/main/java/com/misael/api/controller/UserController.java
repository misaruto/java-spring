package com.misael.api.controller;

import java.util.List;

import com.misael.api.model.User;
import com.misael.api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

        @Autowired
        private UserRepository userRepository;

        @GetMapping("/list")
        public List<User> listar() {
                return userRepository.findAll();
        }

        @PostMapping("/create")
        @ResponseStatus(HttpStatus.CREATED)
        public User create(@RequestBody User user) {
                return userRepository.save(user);
        }
}
