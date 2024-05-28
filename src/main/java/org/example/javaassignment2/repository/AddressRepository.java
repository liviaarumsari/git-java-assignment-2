package org.example.javaassignment2.repository;

import org.example.javaassignment2.entity.Address;
import org.example.javaassignment2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findAddressByUser(User user);
}
