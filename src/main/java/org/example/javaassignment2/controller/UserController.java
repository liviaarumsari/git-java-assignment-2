package org.example.javaassignment2.controller;

import org.example.javaassignment2.entity.User;
import org.example.javaassignment2.repository.AddressRepository;
import org.example.javaassignment2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }
}
