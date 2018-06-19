package com.example.crm_system.service;

import com.example.crm_system.model.Contractors;
import lombok.extern.java.Log;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Class responsible for search field functionality
 */
@Repository
@Transactional
@Log
public class HibernateSearchService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Contractors> fuzzySearch(String searchTerm) {

        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
        QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Contractors.class).get();
        Query luceneQuery = qb.keyword().fuzzy().withEditDistanceUpTo(1).withPrefixLength(1).onFields("name")
                .matching(searchTerm).createQuery();

        FullTextQuery jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Contractors.class);

        List<Contractors> contractorsList = null;
        try {
            contractorsList = jpaQuery.getResultList();
        } catch (NoResultException nre) {
            log.warning("No result found");
        }
        return contractorsList;
    }
}
