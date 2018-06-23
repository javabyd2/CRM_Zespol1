package com.example.crm_system.controller;

import com.example.crm_system.model.Contractors;
import com.example.crm_system.model.Note;
import com.example.crm_system.model.User;
import com.example.crm_system.service.ContractorsService;
import com.example.crm_system.service.HibernateSearchService;
import com.example.crm_system.service.NoteService;
import com.example.crm_system.service.UserServiceImpl;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller for the HTML
 */
@Controller
@Log
public class WebController {

    private final UserServiceImpl userService;
    private HibernateSearchService searchService;
    private NoteService noteService;

    private ContractorsService contractorsService;

    @Autowired
    public WebController(UserServiceImpl userService, HibernateSearchService searchService,
                         ContractorsService contractorsService, NoteService noteService) {
        this.userService = userService;
        this.searchService = searchService;
        this.contractorsService = contractorsService;
        this.noteService = noteService;
    }

    @GetMapping(value = "/addUser")
    public ModelAndView addUser() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("addUser");
        return modelAndView;
    }

    @PostMapping(value = "addUser")
    public ModelAndView saveUser(@Valid User user, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("addUser");
        } else {
            userService.addContributor(user);
            modelAndView.addObject("successMessage", "New user added");
        }
        modelAndView.setViewName("addUser");
        return modelAndView;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
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

    @PostMapping(value = "addNewContractorsForm")
    public String addNewContractors(@ModelAttribute("contractors") Contractors contractors, RedirectAttributes redirectAttributes) {
        contractorsService.save(contractors);
        redirectAttributes.addFlashAttribute("successMessage", "Dodano pomyślnie");
        return "redirect:/addNewContractorsForm";
    }

    @GetMapping(value = "/addNewContractorsForm")
    public ModelAndView addNewContractorsForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addNewContractorsForm");
        modelAndView.addObject("contractors", new Contractors());
        return modelAndView;
    }
    @GetMapping(value = "/addNote")
    public ModelAndView addNote(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("note", new Note());
        modelAndView.setViewName("addNote");
        return modelAndView;
    }
    @PostMapping(value = "addNote")
    public ModelAndView saveNote(Note note, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("addNote");
        } else {
            noteService.saveNote(note);
            modelAndView.addObject("successMessage", "New note added");
        }
        modelAndView.setViewName("addNote");
        return modelAndView;
    }
}
