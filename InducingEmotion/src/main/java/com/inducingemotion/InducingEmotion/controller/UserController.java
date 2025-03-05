package com.inducingemotion.InducingEmotion.controller;

import com.inducingemotion.InducingEmotion.model.User;
import com.inducingemotion.InducingEmotion.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private  final UserService userService;

    public  UserController(UserService userService){
        this.userService = userService;
    }
@PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Map<String, String> request){
        String name = request.get("name");
        String email = request.get("email");
        String phone = request.get("phone");
        String password = request.get("password");
        if (name == null || email == null || password == null || phone == null){
            return ResponseEntity.badRequest().body("Todos campos são obrigatorios!");
        }
    User newUser = userService.registerUser(name, email,password,phone);
    return ResponseEntity.ok(Map.of("Mensagem", "Usuario registrado com sucesso!", "UserId", newUser.getId()));
    }
}
