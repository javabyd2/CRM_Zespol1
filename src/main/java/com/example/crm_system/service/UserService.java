package com.example.crm_system.service;

import com.example.crm_system.model.User;

import java.util.List;

public interface UserService {

    User findUserByEmail(String email);

    void saveUser(User user);

    List<User> getUsers();

    void deleteUser(Long id);

    User getUserById(Long id);

    void editUser(Long id, User user);
}