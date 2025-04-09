package com.inducingemotion.InducingEmotion.entitys;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Entity
@Data
@Table(name = "inducing")
public class Inducing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_inducing;

    @JoinColumn(name = "id_user")
    private Long id_user;

    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private Time time;

    @JoinColumn(name = "id_emotion")
    private Long emotion_expected;

    @JoinColumn(name = "id_emotion")
    private Long emotion_detected;

    @Column(nullable = false)
    private Float porcent_Happy;

    @Column(nullable = false)
    private Float porcent_Sad;

    @Column(nullable = false)
    private Float porcent_Neutral;

    @Column(nullable = false)
    private Float porcent_Anger;

    @Column(nullable = false)
    private Float porcent_Surprice;


}
