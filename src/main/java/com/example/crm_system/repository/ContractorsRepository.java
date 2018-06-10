package com.example.crm_system.repository;

import com.example.crm_system.model.Contractors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ContractorsRepository extends JpaRepository<Contractors, Long> {

    @Modifying
    @Query("update Contractors c set c.phone = ?1, c.email = ?2, c.assignedTo = ?3 where c.id = ?4")
    //TODO: change assignedTo to User once model updated with relations
    public void updateContractor(Long id, Long phone, String email, String assignedTo);
}
