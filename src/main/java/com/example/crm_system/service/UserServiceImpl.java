package com.example.crm_system.service;

import com.example.crm_system.model.Role;
import com.example.crm_system.model.User;
import com.example.crm_system.repository.RoleRepository;
import com.example.crm_system.repository.UserRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service("userService")
@Log
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    public void addContributor(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
        log.info("Created new user with an id: " + user.getId());
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(Long id) {
        if(getUserById(id).isPresent()) {
            userRepository.delete(getUserById(id).get());
            log.info("Deleted user with an id: " + id);
        }
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User editUser(Long id, User user){
        Optional<User> fromDb = getUserById(id);
        if(fromDb.isPresent()) {
            User toBeUpdated = fromDb.get();
            toBeUpdated.setPassword(user.getPassword());
            toBeUpdated.setEmail(user.getEmail());
            saveUser(toBeUpdated);
            log.info("Edited user with an id: " + id);
            return toBeUpdated;
        }else{
            return null;
        }
    }

}