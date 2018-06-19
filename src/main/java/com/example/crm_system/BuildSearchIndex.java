package com.example.crm_system;

import lombok.extern.java.Log;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Class responsible for indexing already existing in our database entities
 * that are available to search through with Hibernate Search
 */
@Component
@Log
public class BuildSearchIndex implements ApplicationListener<ApplicationReadyEvent>{

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        try{
            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
            fullTextEntityManager.createIndexer().startAndWait();
        }catch (InterruptedException e){
            log.warning("An error occurred trying to build the search index: " + e.toString());
        }
    }
}
