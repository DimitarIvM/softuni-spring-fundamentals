package com.softuni.mobilele.service;

import com.softuni.mobilele.repository.ModelRepository;
import org.springframework.stereotype.Service;

@Service
public class ModelService {

    private ModelRepository modelRepository;

    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }
}
