package com.example.crm_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/secured")
    @ResponseBody
    public String secured() {
        return "secret";
    }

    @GetMapping("/loginform")
    public String loginForm() {
        return "login_form.html";
    }
}