package com.example.crm_system.serviceTests;

import com.example.crm_system.model.Contacts;
import com.example.crm_system.repository.ContactsRepository;
import com.example.crm_system.service.ContactsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class ContactsServiceTest {

    private ContactsRepository contactsRepository;
    private ContactsService contactsService;
    private Contacts contacts;

    @Before
    public void setUp(){
        contactsRepository = Mockito.mock(ContactsRepository.class);
        contactsService = new ContactsService(contactsRepository);
        contacts = new Contacts();
        String email = "newContact@email.cs";
        contacts.setMail(email);
        contacts.setId(1L);
    }

    @Test
    public void whenSavedDateCreatedIsSet(){
        contactsService.saveContact(contacts);
        assertThat(contacts.getDataCreated()).isNotNull();

        contactsService.deleteContact(1L);
        Contacts found = contactsService.getContactById(contacts.getId()).orElse(null);
        assertThat(found).isNull();
    }

    @Test
    public void whenDeletedRecordNotFound(){
        contactsService.saveContact(contacts);
        contactsService.deleteContact(1L);

        Contacts found = contactsService.getContactById(contacts.getId()).orElse(null);
        assertThat(found).isNull();
    }
}
