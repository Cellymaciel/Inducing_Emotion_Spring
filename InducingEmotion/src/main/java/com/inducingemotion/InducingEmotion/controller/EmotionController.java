package com.inducingemotion.InducingEmotion.controller;

import com.inducingemotion.InducingEmotion.model.Emotion;
import com.inducingemotion.InducingEmotion.service.EmotionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("api/emotion")
public class EmotionController {
    private  final EmotionService emotionService;

    public EmotionController(EmotionService emotionService){
        this.emotionService = emotionService;
    }
@PostMapping("/NewEmotion" )
    public ResponseEntity<?> saveEmotion (@RequestBody Map<String, String> request){
        String name = request.get("name");
        Emotion newEmotion = emotionService.saveEmotion(name);
        return  ResponseEntity.ok(Map.of("Mensagem","Emoção salva com sucesso", "EmotionId",newEmotion.getId()));

    }
}
