package com.softuni.mobilele.service;

import com.softuni.mobilele.model.entity.User;
import com.softuni.mobilele.model.entity.dto.UserRegistrationDTO;
import com.softuni.mobilele.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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


}
