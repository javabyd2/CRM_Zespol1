package com.example.crm_system.controller;

import com.example.crm_system.model.Contractors;
import com.example.crm_system.model.User;
import com.example.crm_system.service.HibernateSearchService;
import com.example.crm_system.service.UserService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Controller for the HTML
 */
@Controller
@Log
public class WebController {

    private final UserService userService;
    private HibernateSearchService searchService;

    @Autowired
    public WebController(UserService userService, HibernateSearchService searchService) {
        this.userService = userService;
        this.searchService = searchService;
    }

    @GetMapping(value = "/addUser")
    public ModelAndView addUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("addUser");
        return modelAndView;
    }

    @PostMapping(value = "addUser")
    public ModelAndView saveUser(User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
        } else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "Dodano użytkownika");
        }
        modelAndView.setViewName("addUser");
        return modelAndView;
    }

    @GetMapping(value = "/search")
    public String search(@RequestParam(value = "search", required = false) String q, Model model) {
        List<Contractors> searchResults = null;
        try {
            searchResults = searchService.fuzzySearch(q);

        } catch (Exception ex) {

            log.info("Starting up search..." + ex.toString());

        }finally {
            if(searchResults!=null){
                int size = searchResults.size();
                model.addAttribute("resultsFound", "Results found: " + size);
                log.info("Search results: " + size);
           }
        }
        model.addAttribute("search", searchResults);
        return "search";
    }
}
