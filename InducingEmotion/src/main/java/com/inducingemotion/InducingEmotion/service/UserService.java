package com.inducingemotion.InducingEmotion.service;

import com.inducingemotion.InducingEmotion.model.User;
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
        String hashedPassword = passwordEncoder.encode(password);
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(hashedPassword);
        user.setPhone(phone);
        return userRepository.save(user);
    }
}
