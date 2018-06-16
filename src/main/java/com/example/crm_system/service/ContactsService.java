package com.example.crm_system.service;

import com.example.crm_system.model.Contacts;
import com.example.crm_system.repository.ContactsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsService {

    private ContactsRepository contactsRepository;

    @Autowired
    public ContactsService(ContactsRepository contactsRepository) {
        this.contactsRepository = contactsRepository;
    }

    public Contacts saveContact(Contacts contacts){
        return contactsRepository.save(contacts);
    }

    public List<Contacts> getContacts(){
        return contactsRepository.findAll();
    }

    public Contacts getContactById(Long id){
        return contactsRepository.findById(id).get();
    }

    public void deleteContact(Contacts contacts){
        contactsRepository.delete(contacts);
    }
//    public void updateContact(Contacts contacts){
//        contactsRepository.updateContact(contacts.getId(), contacts.getAssignedTo(), contacts.getMobile());
//    }
}
