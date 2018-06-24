package com.example.crm_system.service;

import com.example.crm_system.model.User;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);

}