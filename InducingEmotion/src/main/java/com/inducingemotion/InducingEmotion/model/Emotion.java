package com.inducingemotion.InducingEmotion.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "emotions")
@Data
public class Emotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(nullable = false)
    private  String name;

    @Column(nullable = false)
    private LocalDateTime detecedAt = LocalDateTime.now();
}
