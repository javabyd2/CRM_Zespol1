package com.example.crm_system.service;

import com.example.crm_system.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findUserByEmail(String email);

    void saveUser(User user);

    List<User> getUsers();

    void deleteUser(Long id);

    Optional<User> getUserById(Long id);

    User editUser(Long id, User user);
}