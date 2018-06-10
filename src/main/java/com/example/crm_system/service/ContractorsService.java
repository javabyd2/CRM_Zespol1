package com.example.crm_system.service;

import com.example.crm_system.model.Contractors;
import com.example.crm_system.repository.ContractorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractorsService {

    private ContractorsRepository contractorsRepository;

    @Autowired
    public ContractorsService(ContractorsRepository contractorsRepository) {
        this.contractorsRepository = contractorsRepository;
    }

    public Contractors addContractor(Contractors contractors){
        return contractorsRepository.save(contractors);
    }

    public void updateContractor(Contractors contractors){
        contractorsRepository.updateContractor(contractors.getId(), contractors.getPhone(),
                contractors.getEmail(), contractors.getAssignedTo());
    }
}
