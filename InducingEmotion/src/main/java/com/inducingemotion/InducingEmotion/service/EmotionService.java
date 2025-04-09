package com.inducingemotion.InducingEmotion.service;

import com.inducingemotion.InducingEmotion.entitys.Emotion;
import com.inducingemotion.InducingEmotion.repository.EmotionRepository;
import org.springframework.stereotype.Service;

@Service
public class EmotionService {
    private final EmotionRepository emotionRepository;
    public  EmotionService (EmotionRepository emotionRepository){

        this.emotionRepository = emotionRepository;
    }

    public Emotion saveEmotion(String name){
        Emotion newEmotion = new Emotion();
        newEmotion.setName(name);
        return emotionRepository.save(newEmotion);
    }
}
