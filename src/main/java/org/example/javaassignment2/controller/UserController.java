package org.example.javaassignment2.controller;

import org.example.javaassignment2.entity.Address;
import org.example.javaassignment2.entity.User;
import org.example.javaassignment2.exception.UserNotFoundException;
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
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    // Get all users
    @GetMapping("")
    public List<User> retrieveAllUsers() {
        List<User> users = userRepository.findAll();

        logger.info("Daftar user: " + users);
        
        return users;
    }

    // Get one user + address (id static: 1)
    // Return exception if user not found
    @GetMapping("/id")
    public User retrieveUser() {
        Long id = 1L;
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            logger.info("Tidak ditemukan user dengan id " + id);
            throw new UserNotFoundException("Tidak ditemukan user dengan id " + id);
        }

        logger.info("User: " + user.get());

        return user.get();
    }

    // Add new user with static data
    @PostMapping("")
    public String addNewUser () {
        User newUser = new User("liviaarumsari16@gmail.com", "Livia", "livia123");
        userRepository.save(newUser);

        logger.info("Berhasil menambahkan user baru: " + newUser);

        return "Berhasil menambahkan user dengan id " + newUser.getId();
    }


    // Add new address by user id
    // Get the user id of a user with empty address
    // Return exception if all user already has address
    @PostMapping("/id/address")
    public String addNewAddress () {
        User user = userRepository.findFirstByAddressIsNull();

        if (user == null) {
            logger.info("Tidak ditemukan user tanpa alamat");
            throw new UserNotFoundException("Tidak ditemukan user tanpa alamat");
        }

        Address newAddress = new Address("Bandung", "Indonesia", "Jawa Barat", "Jl. Ganesa No. 10", "41305", user);
        addressRepository.save(newAddress);

        return "Berhasil menambahkan address ke user dengan id " + user.getId();
    }
}
