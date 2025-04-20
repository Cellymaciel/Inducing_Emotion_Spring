package com.inducingemotion.InducingEmotion.dto;

import java.time.Instant;

public record EmotionDTO(
        String emotion,
        Instant time,
        Long videoId
) {
}
