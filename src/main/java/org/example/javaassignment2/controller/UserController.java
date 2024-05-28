package org.example.javaassignment2.controller;

import org.example.javaassignment2.entity.User;
import org.example.javaassignment2.repository.AddressRepository;
import org.example.javaassignment2.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("")
    public List<User> retrieveAllUsers() {
        List<User> users = userRepository.findAll();

        logger.info("Daftar user: " + users);
        
        return users;
    }

    @PostMapping("")
    public String addNewUser () {
        User newUser = new User("liviaarumsari16@gmail.com", "Livia", "livia123");
        userRepository.save(newUser);

        logger.info("Berhasil menambahkan user baru: " + newUser);

        return "Berhasil";
    }
}
