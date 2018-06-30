package com.example.crm_system.service;

import com.example.crm_system.model.Offer;
import com.example.crm_system.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    private OfferRepository offerRepository;

    @Autowired
    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public Offer saveOffer(Offer offer){
        offer.setDateCreated(new java.sql.Timestamp(System.currentTimeMillis()));
        return offerRepository.save(offer);
    }

    public List<Offer> getOffers(){
        return offerRepository.findAll();
    }

    public Offer getOfferById(Long id){
        return offerRepository.findById(id).get();
    }

    public void deleteOffer(Long id){
        offerRepository.delete(getOfferById(id));
    }
}
