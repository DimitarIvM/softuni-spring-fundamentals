package com.softuni.mobilele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offers")
public class AllOffersController {

    @GetMapping("/all")
    public String allOffers(){

        return "offers";
    }
}
