package com.inducingemotion.InducingEmotion.entitys;

import com.inducingemotion.InducingEmotion.enuns.Emotion;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
@Getter
@Entity(name = "emotion_detected")
@Table(name = "emotion_detected")
public class EmotionDetected {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_Emotion", nullable = false)
    private Emotion emocao;

   @Column(name = "id_Videos", nullable = false)
   private  Long idVideo;

    @Column(name = "emod_data_deteccao", nullable = false)
    private Date dataDeteccao;

    @ManyToOne
    @JoinColumn(name = "emod_usuario", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "emod_Inducucao", nullable = false)
    private Inducing inducing;
}
