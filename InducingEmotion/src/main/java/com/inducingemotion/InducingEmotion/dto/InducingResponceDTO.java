package com.inducingemotion.InducingEmotion.dto;

import com.inducingemotion.InducingEmotion.entitys.User;

import java.time.LocalDateTime;
import java.util.List;

public class InducingResponceDTO {
    private User user;
    private LocalDateTime dataInicio;
    private String emocaoEscolha;
    private String emocaoDominate;
    private Long idInducion;
    private List<VideoEmotionDetailDTO> detailsInducing;
    private List<String> allDetectedEmotions; // Novo campo

    public InducingResponceDTO(User user, LocalDateTime dataInicio, String emocaoEscolha, String emocaoDominate, Long idInducion, List<VideoEmotionDetailDTO> detailsInducing, List<String> allDetectedEmotions) {
        this.user = user;
        this.dataInicio = dataInicio;
        this.emocaoEscolha = emocaoEscolha;
        this.emocaoDominate = emocaoDominate;
        this.idInducion = idInducion;
        this.detailsInducing = detailsInducing;
        this.allDetectedEmotions = allDetectedEmotions;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public String getEmocaoEscolha() {
        return emocaoEscolha;
    }

    public String getEmocaoDominate() {
        return emocaoDominate;
    }

    public Long getIdInducion() {
        return idInducion;
    }

    public List<VideoEmotionDetailDTO> getDetailsInducing() {
        return detailsInducing;
    }

    public List<String> getAllDetectedEmotions() {
        return allDetectedEmotions;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setEmocaoEscolha(String emocaoEscolha) {
        this.emocaoEscolha = emocaoEscolha;
    }

    public void setEmocaoDominate(String emocaoDominate) {
        this.emocaoDominate = emocaoDominate;
    }

    public void setIdInducion(Long idInducion) {
        this.idInducion = idInducion;
    }

    public void setDetailsInducing(List<VideoEmotionDetailDTO> detailsInducing) {
        this.detailsInducing = detailsInducing;
    }

    public void setAllDetectedEmotions(List<String> allDetectedEmotions) {
        this.allDetectedEmotions = allDetectedEmotions;
    }
}

