package com.inducingemotion.InducingEmotion.service;

import com.inducingemotion.InducingEmotion.entitys.User;
import com.inducingemotion.InducingEmotion.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    };

    public User registerUser(String name, String email, String password, String phone){

        if ( userRepository.existsByEmail(email)){
            throw  new RuntimeException("Usuario ha existente : " + email);
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);
        return userRepository.save(user);
    }
}
