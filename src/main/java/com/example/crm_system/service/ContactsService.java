package com.example.crm_system.service;

import com.example.crm_system.model.Contacts;
import com.example.crm_system.repository.ContactsRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

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

    public Contacts getContactById(Long id) {
        return contactsRepository.findById(id).get();
    }

    public void deleteContact(Long id) {
        contactsRepository.delete(getContactById(id));
        log.info("Deleting contact with an id: " + id);
    }

    public void editContact(Long id, Contacts contacts) {
        Contacts toBeUpdated = getContactById(id);
        if (!toBeUpdated.getMobile().equals(contacts.getMobile())) {
            toBeUpdated.setMobile(contacts.getMobile());
            log.info("Mobile updated to: " + contacts.getMobile());
        }
        if (!toBeUpdated.getMail().equals(contacts.getMail())) {
            toBeUpdated.setMail(contacts.getMail());
            log.info("Mail updated to: " + contacts.getMail());
        }
        toBeUpdated.setDataModified(new Timestamp(System.currentTimeMillis()));
        saveContact(toBeUpdated);
        log.info("Updated contact with an id: " + id);
    }
}
