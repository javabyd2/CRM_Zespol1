package com.example.crm_system.repository;

import com.example.crm_system.model.Contractors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("contractorsRepository")
public interface ContractorsRepository extends JpaRepository<Contractors, Long> {

}