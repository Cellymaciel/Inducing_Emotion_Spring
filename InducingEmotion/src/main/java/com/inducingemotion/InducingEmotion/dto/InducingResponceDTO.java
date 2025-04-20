package com.inducingemotion.InducingEmotion.dto;

import com.inducingemotion.InducingEmotion.entitys.User;

import java.time.LocalDateTime;
import java.util.List;

public record InducingResponceDTO(
        User user,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        String emocaoEscolha,
        String emocaoDominate,
        Long idInducion,
        List<VideoEmotionDetailDTO> detailsInducing
) {
}

