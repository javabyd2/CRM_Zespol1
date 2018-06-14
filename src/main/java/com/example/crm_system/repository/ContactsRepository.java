package com.example.crm_system.repository;

import com.example.crm_system.model.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ContactsRepository extends JpaRepository<Contacts, Long> {

    //change values depending on business logic - ask Krzys if needed
    @Modifying
    @Query("update Contacts c set c.phone = ?1, c.email = ?2, c.assignedTo = ?3 where c.id = ?4")
    public void updateContact(Long id, Long phone, String email, String assignedTo);
}
