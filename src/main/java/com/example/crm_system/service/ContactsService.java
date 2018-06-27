package com.example.crm_system.service;

import com.example.crm_system.model.Contacts;
import com.example.crm_system.repository.ContactsRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Log
@Service
public class ContactsService {

    private ContactsRepository contactsRepository;

    @Autowired
    public ContactsService(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    public void saveContact(Contacts contacts) {
        contacts.setDataCreated(new Timestamp(System.currentTimeMillis()));
        contactsRepository.save(contacts);
    }

    public List<Contacts> getContacts() {
        return contactsRepository.findAll();
    }

    public Optional<Contacts> getContactById(Long id) {
        return contactsRepository.findById(id);
    }

    public void deleteContact(Long id) {
        Optional<Contacts> fromDb = getContactById(id);
        if(fromDb.isPresent()) {
            contactsRepository.delete(getContactById(id).get());
            log.info("Deleting contact with an id: " + id);
        }
    }

    public Contacts editContact(Long id, Contacts contacts) {
        Optional<Contacts> fromDb = getContactById(id);
        if (fromDb.isPresent()) {
            Contacts toBeUpdated = fromDb.get();
            if (!toBeUpdated.getMobile().equals(contacts.getMobile())) {
                toBeUpdated.setMobile(contacts.getMobile());
                log.info("Mobile updated to: " + contacts.getMobile());
            }
            if (!toBeUpdated.getMail().equals(contacts.getMail())) {
                toBeUpdated.setMail(contacts.getMail());
                log.info("Mail updated to: " + contacts.getMail());
            }
            saveContact(toBeUpdated);
            log.info("Edited contact with an id: " + id);
            return toBeUpdated;
        } else {
            return null;
        }
    }
}