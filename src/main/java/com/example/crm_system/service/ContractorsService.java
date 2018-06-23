package com.example.crm_system.service;

import com.example.crm_system.model.Contractors;
import com.example.crm_system.repository.ContractorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractorsService {

    private ContractorsRepository contractorsRepository;

    @Autowired
    public ContractorsService(ContractorsRepository contractorsRepository) {
        this.contractorsRepository = contractorsRepository;
    }

    public List<Contractors> getContractors() {
        return contractorsRepository.findAll();
    }

    public Optional<Contractors> getContractorsById(Long id) {
        return contractorsRepository.findById(id);
    }

    public void updateContractor(Contractors contractors){
        contractorsRepository.updateContractor(contractors.getId(), contractors.getPhone(),
                contractors.getEmail(), contractors.getAssignedTo());
    }

    public Contractors save (Contractors contractors) {
        return contractorsRepository.save(contractors);
    }
}