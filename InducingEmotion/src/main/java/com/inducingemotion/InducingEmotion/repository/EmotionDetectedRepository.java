package com.inducingemotion.InducingEmotion.repository;

import com.inducingemotion.InducingEmotion.entitys.EmotionDetected;
import com.inducingemotion.InducingEmotion.entitys.Inducing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmotionDetectedRepository extends JpaRepository<EmotionDetected, Long> {
    List<EmotionDetected> findByInducing(Inducing inducing);
}
