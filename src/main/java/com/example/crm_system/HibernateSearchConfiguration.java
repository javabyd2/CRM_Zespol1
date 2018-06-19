//package com.example.crm_system;
//
//import com.example.crm_system.service.HibernateSearchService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.persistence.EntityManager;
//
////@EnableAutoConfiguration
//@Configuration
//public class HibernateSearchConfiguration {
//
//    @Autowired
//    private EntityManager bentityManager;
//
//    @Bean
//    HibernateSearchService hibernateSearchService(){
//       HibernateSearchService hibernateSearchService = new HibernateSearchService(bentityManager);
//       hibernateSearchService.initializeHibernateSearch();
//       return hibernateSearchService();
//    }
//}
