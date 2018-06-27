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

    @Before
    public void setUp(){
        contactsRepository = Mockito.mock(ContactsRepository.class);
        contactsService = new ContactsService(contactsRepository);
    }

    @Test
    public void whenAddedContactCanBeFind(){
        Contacts contacts = new Contacts();
        String email = "newContact@email.cs";
        contacts.setMail(email);
        contacts.setId(1L);
        contactsService.saveContact(contacts);
        contactsService.deleteContact(1L);
//        assertThat(contacts.getId()).isNull();
        assertThat(contacts.getMail()).isNull();
//        assertThat(contacts.getMail()).isEqualTo(newDetails.getMail());
    }
}
