package com.inducingemotion.InducingEmotion.controller;

import com.inducingemotion.InducingEmotion.entitys.Inducing;
import com.inducingemotion.InducingEmotion.service.InducingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.Map;

@RestController
@RequestMapping("api/inducing")
public class InducingController {

    private final InducingService inducingService;

    public InducingController(InducingService inducingService) {
        this.inducingService = inducingService;
    }

    @PostMapping("/newInducing")
    public ResponseEntity<Inducing> saveInducing(
            @RequestParam Long id_user,
            @RequestParam Time time,
            @RequestParam Long emotion_expected,
            @RequestParam Long emotion_detected,
            @RequestParam Float porcent_Sad,
            @RequestParam Float porcent_Happy,
            @RequestParam Float porcent_Neutral,
            @RequestParam Float porcent_Anger,
            @RequestParam Float porcent_Surprise) {

        Inducing savedInducing = inducingService.saveInducing(
                id_user, time, emotion_expected, emotion_detected,
                porcent_Sad, porcent_Happy, porcent_Neutral, porcent_Anger, porcent_Surprise
        );
        return ResponseEntity.ok(savedInducing);
    }
}
