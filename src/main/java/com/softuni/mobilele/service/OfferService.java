package com.softuni.mobilele.service;

import com.softuni.mobilele.repository.OfferRepository;
import org.springframework.stereotype.Service;

@Service
public class OfferService {

    private OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }
}
