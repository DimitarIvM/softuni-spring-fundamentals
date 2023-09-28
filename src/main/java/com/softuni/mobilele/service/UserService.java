package com.softuni.mobilele.service;

import com.softuni.mobilele.model.entity.User;
import com.softuni.mobilele.model.entity.dto.UserLoginDTO;
import com.softuni.mobilele.model.entity.dto.UserRegistrationDTO;
import com.softuni.mobilele.repository.UserRepository;
import com.softuni.mobilele.utils.CurrentUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    private CurrentUser currentUser;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    public void registerUser(UserRegistrationDTO userRegistrationDTO) {

        userRepository.save(map(userRegistrationDTO));


    }

    private  User map(UserRegistrationDTO userRegistrationDTO){
       User user = new User();

       user.setFirstName(userRegistrationDTO.getFirstName());
       user.setLastName(userRegistrationDTO.getLastName());
       user.setActive(true);
       user.setCreated(LocalDateTime.now());
       user.setUsername(userRegistrationDTO.getUsername());
       user.setPassword(passwordEncoder.encode( userRegistrationDTO.getPassword()));

       return user;


    }


    public boolean loginUser(UserLoginDTO userLoginDTO) {

        User user = userRepository.findByUsername(userLoginDTO.getUsername())
                .orElse(null);

        boolean isLoginSuccessful = false;

        if(user!=null){
            String rawPassword = userLoginDTO.getPassword();
            String encodedPassword = user.getPassword();

            isLoginSuccessful = encodedPassword !=null && passwordEncoder.matches(rawPassword,encodedPassword);

            if (isLoginSuccessful){
                currentUser.setLogged(true);
                currentUser.setFirstName(user.getFirstName());
                currentUser.setLastName(user.getLastName());
            }else {
                currentUser.logout();
            }


        }

        return isLoginSuccessful;

    }

    public void logoutUser(){

        currentUser.logout();
    }
}
