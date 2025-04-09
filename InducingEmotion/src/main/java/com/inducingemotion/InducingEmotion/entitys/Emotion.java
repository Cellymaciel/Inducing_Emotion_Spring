package com.inducingemotion.InducingEmotion.entitys;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "emotions")
@Data
public class Emotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id_emotion;
    @Column(nullable = false)
    private  String name;

    @Column(nullable = false)
    private LocalDateTime detecedAt = LocalDateTime.now();
}
