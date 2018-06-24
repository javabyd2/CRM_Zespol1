package com.example.crm_system.controller;

import com.example.crm_system.model.Contractors;
import com.example.crm_system.model.Note;
import com.example.crm_system.model.Task;
import com.example.crm_system.model.User;
import com.example.crm_system.service.*;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    private TaskService taskService;

    private ContractorsService contractorsService;

    @Autowired
    public WebController(UserServiceImpl userService, HibernateSearchService searchService,
                         ContractorsService contractorsService, NoteService noteService, TaskService taskService) {
        this.userService = userService;
        this.searchService = searchService;
        this.contractorsService = contractorsService;
        this.noteService = noteService;
        this.taskService = taskService;
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

    @GetMapping(value = "/home")
    public String search(@RequestParam(value = "search", required = false) String q, Model model) {
        List<Contractors> searchResults = null;
        try {
            searchResults = searchService.fuzzySearch(q);

        } catch (Exception ex) {

            log.info("Starting up search..." + ex.toString());

        } finally {
            if (searchResults != null) {
                int size = searchResults.size();
                model.addAttribute("resultsFound", "Results found: " + size);
                log.info("Search results: " + size);
            }
        }
        model.addAttribute("search", searchResults);
        return "search";
    }

    @PostMapping(value = "addNewContractorsForm")
    public ModelAndView addNewContractors(@Valid Contractors contractors, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("addNewContractorsForm");
        } else {
            contractorsService.save(contractors);
            modelAndView.addObject("successMessage", "Dodano pomyślnie");
        }
        modelAndView.setViewName("addNewContractorsForm");
        return modelAndView;
    }

    @GetMapping(value = "/addNewContractorsForm")
    public ModelAndView addNewContractorsForm() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addNewContractorsForm");
        modelAndView.addObject("contractors", new Contractors());
        return modelAndView;
    }

    @GetMapping(value = "/addNote")
    public ModelAndView addNote() {
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

    @GetMapping(value = "/notes")
    public ModelAndView notes() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("notesList", noteService.getNotes());
        modelAndView.setViewName("notes");
        return modelAndView;
    }

    @DeleteMapping(value = "/notes/{id}")
    public String deleteNote(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        noteService.deleteNote(id);
        redirectAttributes.addFlashAttribute("successMessage", "Note deleted");
        return "redirect:/notes";
    }

    @GetMapping(value = "/showScheduledTasks")
    public ModelAndView showScheduledTasks() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("taskList", taskService.getTasks());
        modelAndView.setViewName("showScheduledTasks");
        return modelAndView;
    }


    @GetMapping(value = "/addNewPhoneToTasks")
    public ModelAndView addNewPhoneToTasks() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("task", new Task());
        modelAndView.setViewName("addNewPhoneToTasks");
        return modelAndView;
    }

    @PostMapping(value = "addNewPhoneToTasks")
    public ModelAndView saveNewPhoneToTasks(Task task, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("addNewPhoneToTasks");
        } else {
            taskService.saveTask(task);
            modelAndView.addObject("successMessage", "New phone to tasks added");
        }
        modelAndView.setViewName("addNewPhoneToTasks");
        return modelAndView;
    }

    @GetMapping(value = "/contractors")
    public ModelAndView contractors() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("contractorsList", contractorsService.getContractors());
        modelAndView.setViewName("contractors");
        return modelAndView;
    }

    @DeleteMapping(value = "/contractors/{id}")
    public String deleteContractor(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        contractorsService.deleteContractor(id);
        redirectAttributes.addFlashAttribute("successMessage", "Contractor deleted");
        return "redirect:/contractors";
    }

    @GetMapping(value = "/editContractor/{id}")
    public ModelAndView editContractor(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("contractor", contractorsService.getContractorsById(id));
        modelAndView.setViewName("editContractor");
        return modelAndView;
    }

    @PostMapping(value = "/editContractor/{id}")
    public String updateContractor(@PathVariable("id") Long id, Contractors contractors, RedirectAttributes redirectAttributes) {
        contractorsService.editContractor(id, contractors);
        redirectAttributes.addFlashAttribute("successMessage", "Contractor edited");
        return "redirect:/contractors";
    }

    @GetMapping(value = "/users")
    public ModelAndView users() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usersList", userService.getUsers());
        modelAndView.setViewName("users");
        return modelAndView;
    }

    @DeleteMapping(value = "/users/{id}")
    public String deleteUser(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        userService.deleteUser(id);
        redirectAttributes.addFlashAttribute("successMessage", "User deleted");
        return "redirect:/users";
    }

    @GetMapping(value = "/editUser/{id}")
    public ModelAndView editUser(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", userService.getUserById(id));
        modelAndView.setViewName("editUser");
        return modelAndView;
    }

    @PostMapping(value = "/editUser/{id}")
    public String updateUser(@PathVariable("id") Long id, User user, RedirectAttributes redirectAttributes) {
        userService.editUser(id, user);
        redirectAttributes.addFlashAttribute("successMessage", "User edited");
        return "redirect:/users";
    }
}