package com.example.crm_system.service;

import com.example.crm_system.model.Contractors;
import com.example.crm_system.repository.ContractorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void save (Contractors contractors) {
        contractorsRepository.save(contractors);
    }

    public void deleteContractor(Long id){
        contractorsRepository.delete(getContractorsById(id));
    }

    public void editContractor(Long id, Contractors contractors){
        Contractors toBeEdited = getContractorsById(id);
        toBeEdited.setAddress(contractors.getAddress());
        toBeEdited.setEmail(contractors.getEmail());
        toBeEdited.setPhone(contractors.getPhone());
        save(toBeEdited);
    }
}