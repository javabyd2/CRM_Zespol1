//package com.example.crm_system.controller;
//
//import javax.validation.Valid;
//
//import com.example.crm_system.model.User;
//import com.example.crm_system.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class UserController {
//
//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/register")
//    public String register(Model model) {
//        model.addAttribute("user", new User());
//        return "registerForm";
//    }
//
//    @PostMapping("/register")
//    public String addUser(@ModelAttribute @Valid User user,
//                          BindingResult bindResult) {
//        if (bindResult.hasErrors())
//            return "registerForm";
//        else {
//            userService..addWithDefaultRole(user);
//            return "registerSuccess";
//        }
//    }
//
//}