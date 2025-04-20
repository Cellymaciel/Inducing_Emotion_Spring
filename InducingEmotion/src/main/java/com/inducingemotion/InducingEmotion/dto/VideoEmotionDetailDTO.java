package com.inducingemotion.InducingEmotion.dto;

import java.util.List;

public record VideoEmotionDetailDTO(
        Long video,
        List<String> emotionsDominates
) {
}
