package com.example.crm_system.serviceTests;

import com.example.crm_system.model.Contractors;
import com.example.crm_system.repository.ContractorsRepository;
import com.example.crm_system.service.ContractorsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class ContractorsServiceTest {

    private ContractorsRepository contractorsRepository;
    private ContractorsService contractorsService;

    @Before
    public void setUp(){
        contractorsRepository = Mockito.mock(ContractorsRepository.class);
        contractorsService = new ContractorsService(contractorsRepository);
    }

    @Test
    public void whenSavedDateCreatedIsSet(){
        Contractors contractors = Contractors.builder().name("TestName").industry("TestIndustry").build();

        contractorsService.save(contractors);
        assertThat(contractors.getDateCreated()).isNotNull();
    }
}
