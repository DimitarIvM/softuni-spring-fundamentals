package com.softuni.mobilele.utils;


import com.softuni.mobilele.enums.Category;
import com.softuni.mobilele.model.entity.Brand;
import com.softuni.mobilele.model.entity.Model;
import com.softuni.mobilele.repository.BrandRepository;
import com.softuni.mobilele.repository.ModelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BrandRepository brandRepository;

    private final ModelRepository modelRepository;

    public DataInitializer ( BrandRepository brandRepository, ModelRepository modelRepository) {

        this.brandRepository = brandRepository;

        this.modelRepository = modelRepository;
    }

    @Override
    public void run(String... args) throws Exception {


            Brand brand = new Brand();
            brand.setName("Nissan");

            Model model = new Model();
            model.setBrand(brand);
            model.setName("Skyline");
            model.setCategory(Category.Car);
            model.setImageUrl("https://pin.it/2t8Czm9");
            model.setStartYear(1990);
            model.setEndYear(2017);



            brandRepository.save(brand);
            modelRepository.save(model);






    }
}
