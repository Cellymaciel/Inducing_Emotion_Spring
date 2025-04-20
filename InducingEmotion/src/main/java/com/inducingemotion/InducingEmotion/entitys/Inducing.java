package com.inducingemotion.InducingEmotion.entitys;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Table(name = "inducing")
@Entity
@Data
public class Inducing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "Email_User", referencedColumnName = "email")
    private  User user;

    @Column(name = "Inicio da indução ", nullable = false)
    private LocalDateTime dataInicio = LocalDateTime.now();

    @Column(name = "Fim da indução", nullable = false)
    private LocalDateTime dataFim;

    @Column(name = "Emoção_Induzida")
    private String emocaoEscolha;

}
