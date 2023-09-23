package com.softuni.mobilele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/brands")
@Controller
public class AllBrandController {

    @GetMapping("/all")
    public String loadAllBrands(){

        return "brands.html";
    }


}
