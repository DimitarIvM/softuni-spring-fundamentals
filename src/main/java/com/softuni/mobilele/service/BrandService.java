package com.softuni.mobilele.service;

import com.softuni.mobilele.repository.BrandRepository;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    private BrandRepository brandRepository;

    public BrandService(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


}
