package com.softuni.mobilele.web;

import com.softuni.mobilele.model.entity.dto.UserLoginDTO;
import com.softuni.mobilele.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@Controller
public class UserLoginController {

    private UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){

        return "auth-login";
    }

    @PostMapping("/login")
    public String loginUser(UserLoginDTO userLoginDTO) {


        return "redirect:/";
    }
}
