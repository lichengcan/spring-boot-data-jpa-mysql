package com.bezkoder.spring.datajpa.controller;

import com.bezkoder.spring.datajpa.model.User;
import com.bezkoder.spring.datajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author: lichengcan
 * @date: 2023-06-27 17:05
 * @description
 **/
@RestController
@RequestMapping("/test")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            User _user = userRepository.save(user);
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUser() {
        try {
            User _user = userRepository.getUser();
            return new ResponseEntity<>(_user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/user")
    public ResponseEntity<Integer> updateUser(Integer age) {
        try {
            Integer integer = userRepository.updateUser(age);
            return new ResponseEntity<>(integer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
