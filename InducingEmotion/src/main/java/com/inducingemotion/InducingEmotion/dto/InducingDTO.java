package com.inducingemotion.InducingEmotion.dto;

import com.inducingemotion.InducingEmotion.entitys.User;

import java.time.LocalDateTime;
import java.util.List;

public record InducingDTO(
        LocalDateTime dataInicio,
        String emocaoEscolha,
        LocalDateTime dataFim,
        List<EmotionDTO> listEmotions,
        String email
) {
}
