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

    public Contractors getContractorsById(Long id) {
        return contractorsRepository.findById(id).get();
    }

    public Contractors save (Contractors contractors) {
        return contractorsRepository.save(contractors);
    }

    public void deleteContractor(Long id){
        contractorsRepository.delete(getContractorsById(id));
    }
}