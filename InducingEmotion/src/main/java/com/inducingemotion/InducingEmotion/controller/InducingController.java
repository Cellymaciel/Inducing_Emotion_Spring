package com.inducingemotion.InducingEmotion.controller;

import com.inducingemotion.InducingEmotion.dto.InducingDTO;
import com.inducingemotion.InducingEmotion.dto.InducingResponceDTO;
import com.inducingemotion.InducingEmotion.entitys.Inducing;
import com.inducingemotion.InducingEmotion.service.InducingService;
import com.inducingemotion.InducingEmotion.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/inducing")
public class InducingController {

    @Autowired
    private InducingService inducingService;
    @Autowired
    private UserService userService;


    @PostMapping("/createInducing/{emailUser}")
    public ResponseEntity<Map<String, Long>> salvarInducao(
            @PathVariable String emailUser,
            @RequestBody InducingDTO inducingDTO,
            UriComponentsBuilder uriBuilder

    ){

        Inducing saveInducing = inducingService.saveInducing(inducingDTO, emailUser);
        java.net.URI uri = uriBuilder.path("/inducing/{id}")
                .buildAndExpand(saveInducing.getId())
                .toUri();

        return ResponseEntity.created(uri).body(Collections.singletonMap("idInducion", saveInducing.getId()));
    }

    //Todas induções de todos usuarios
    @GetMapping("/")
    public ResponseEntity<List<InducingResponceDTO>> getAllInducingsWithDetails() {
        List<InducingResponceDTO> allInducings = inducingService.getAllInducingDetails();
        return new ResponseEntity<>(allInducings, HttpStatus.OK);
    }
 //indução especifica
    @GetMapping("/{inducingId}")
    public ResponseEntity<InducingResponceDTO> getInducingDetails(@PathVariable Long inducingId) {
        InducingResponceDTO inducingDetails = inducingService.getInducingDetails(inducingId);
        return new ResponseEntity<>(inducingDetails, HttpStatus.OK);
    }

    //REtorna todas induções do usuario espesufic
    @GetMapping("/user/{emailUser}")
    public ResponseEntity<List<InducingResponceDTO>> getInducingsByUser(@PathVariable String emailUser) {
        List<InducingResponceDTO> userInducings = inducingService.getInducingsByUserEmail(emailUser);
        return new ResponseEntity<>(userInducings, HttpStatus.OK);
    }

    //Retona o utmo criado
    @GetMapping("/user/{emailUser}/last")
    public ResponseEntity<InducingResponceDTO> getLastInducingByUser(@PathVariable String emailUser) {
        InducingResponceDTO lastInducing = inducingService.getLastInducingByUserEmail(emailUser);
        if (lastInducing != null) {
            return new ResponseEntity<>(lastInducing, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
