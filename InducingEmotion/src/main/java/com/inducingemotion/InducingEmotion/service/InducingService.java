package com.inducingemotion.InducingEmotion.service;

import com.inducingemotion.InducingEmotion.entitys.Emotion;
import com.inducingemotion.InducingEmotion.entitys.Inducing;
import com.inducingemotion.InducingEmotion.repository.EmotionRepository;
import com.inducingemotion.InducingEmotion.repository.InducingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
@Service
public class InducingService {

    private final InducingRepository inducingRepository;
    public  InducingService (InducingRepository inducingRepository){
        this.inducingRepository = inducingRepository;
    }

    public Inducing saveInducing(Long id_user, Time time, Long emotion_expected, Long emotion_detected, Float porcent_Sed, Float porcent_Happy, Float porcent_Neutral, Float porcent_Anger, Float porcent_Surprise){
        Inducing newInducing = new Inducing();
        newInducing.setId_user(id_user);
        newInducing.setTime(time);
        newInducing.setEmotion_detected(emotion_detected);
        newInducing.setEmotion_expected(emotion_expected);
        newInducing.setPorcent_Anger(porcent_Anger);
        newInducing.setPorcent_Happy(porcent_Happy);
        newInducing.setPorcent_Neutral(porcent_Neutral);
        newInducing.setPorcent_Sad(porcent_Sed);
        newInducing.setPorcent_Surprice(porcent_Surprise);

        return inducingRepository.save(newInducing);
    }

}
