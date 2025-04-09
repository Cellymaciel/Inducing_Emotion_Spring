package com.inducingemotion.InducingEmotion.repository;

import com.inducingemotion.InducingEmotion.entitys.Emotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmotionRepository extends JpaRepository<Emotion,Long> {
}
