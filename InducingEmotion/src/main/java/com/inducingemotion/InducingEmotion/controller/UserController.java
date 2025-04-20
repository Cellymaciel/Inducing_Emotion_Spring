package com.inducingemotion.InducingEmotion.controller;

import com.inducingemotion.InducingEmotion.dto.LoginDTO;
import com.inducingemotion.InducingEmotion.dto.UserDTO;
import com.inducingemotion.InducingEmotion.entitys.User;
import com.inducingemotion.InducingEmotion.repository.UserRepository;
import com.inducingemotion.InducingEmotion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
@PostMapping("/createUser")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO){

        if (userRepository.existsByEmail(userDTO.email())) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Erro: Email já cadastrado.");
        }

          User user = userService.registerUser(
                  userDTO.name(),
                  userDTO.email(),
                  userDTO.password(),
                  userDTO.phone()
          );
          return ResponseEntity.ok("Criado User com Sucesso");

    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        User user = userRepository.findByEmail(loginDTO.email());
        if (user == null || !user.getPassword().equals(loginDTO.password())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou senha incorretos");
        }
        UserDTO responseUser = new UserDTO(user.getName(), user.getEmail(), null, user.getPhone());
        return ResponseEntity.ok(responseUser);
    }

    @GetMapping("/profile/{email}")
    public ResponseEntity<?> getUserProfile(@PathVariable String email){
        Optional<User> userOptional = userRepository.findById(email);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            return   ResponseEntity.ok(new UserDTO(user.getName(), user.getEmail(), user.getPassword(), user.getPhone()));
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado");
        }
    }
}
