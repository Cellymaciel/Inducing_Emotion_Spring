package com.inducingemotion.InducingEmotion.service;

import com.inducingemotion.InducingEmotion.dto.EmotionDTO;
import com.inducingemotion.InducingEmotion.entitys.EmotionDetected;
import com.inducingemotion.InducingEmotion.entitys.Inducing;
import com.inducingemotion.InducingEmotion.entitys.User;
import com.inducingemotion.InducingEmotion.enuns.Emotion;
import com.inducingemotion.InducingEmotion.repository.EmotionDetectedRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class EmotionDetectedService {
    @Autowired
    private EmotionDetectedRepository emotionDetectedRepository;

    public Boolean saveEmotions(Inducing inducing, User user, List<EmotionDTO> emotions){
        try{
            if(!emotions.isEmpty()){
                for(EmotionDTO emotionDTO :  emotions){
                    EmotionDetected emotionDetected = new EmotionDetected();
                    emotionDetected.setUser(user);
                    emotionDetected.setEmocao(Emotion.getEmotion(emotionDTO.emotion()));
                    emotionDetected.setInducing(inducing);
                    emotionDetected.setDataDeteccao(new Date());
                    emotionDetected.setIdVideo(emotionDTO.videoId());
                    emotionDetectedRepository.save(emotionDetected);
                }
            }
            return true;
        } catch (Exception e ){
            log.error("Não foi possivel salvar as emoções", e);
        }
        return  false;
    }
}
