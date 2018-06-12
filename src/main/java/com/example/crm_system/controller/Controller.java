//package com.example.crm_system.controller;
//
//import com.example.crm_system.model.User;
//import com.example.crm_system.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class Controller {
//
//    private UserService userService;
//
//    @Autowired
//    public Controller(UserService userService) {
//        this.userService = userService;
//    }
//    @PostMapping(value = "/user")
//    public User addUser(User user){
//        return userService..addWithDefaultRole(user);
//    }
//}
