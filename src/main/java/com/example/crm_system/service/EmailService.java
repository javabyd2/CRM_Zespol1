package com.example.crm_system.service;

import com.example.crm_system.model.Email;
import com.example.crm_system.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {

    private EmailRepository emailRepository;

    @Autowired
    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public Email save(Email email){
        return emailRepository.save(email);
    }

    public List<Email> findEmails(){
        return emailRepository.findAll();
    }
}
