package com.inducingemotion.InducingEmotion.service;

import com.inducingemotion.InducingEmotion.dto.InducingDTO;
import com.inducingemotion.InducingEmotion.dto.InducingResponceDTO;
import com.inducingemotion.InducingEmotion.dto.VideoEmotionDetailDTO;
import com.inducingemotion.InducingEmotion.entitys.EmotionDetected;
import com.inducingemotion.InducingEmotion.entitys.Inducing;
import com.inducingemotion.InducingEmotion.entitys.User;
import com.inducingemotion.InducingEmotion.repository.EmotionDetectedRepository;
import com.inducingemotion.InducingEmotion.repository.InducingRepository;
import com.inducingemotion.InducingEmotion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class InducingService {

    @Autowired
    private InducingRepository inducingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmotionDetectedRepository emotionDetectedRepository;
    @Autowired
    private EmotionDetectedService emotionDetectedService;



    public Inducing saveInducing(InducingDTO inducingDTO, String userEmail){
        User user = userRepository.findById(userEmail).orElseThrow(() ->
                new RuntimeException("Usuário não encontrado"));

        Inducing inducing = new Inducing();
        inducing.setUser(user);
        inducing.setEmocaoEscolha(inducingDTO.emocaoEscolha());
        inducing.setDataInicio(inducingDTO.dataInicio());
        inducing.setDataFim(inducingDTO.dataFim());
        Inducing savedInducing = inducingRepository.save(inducing);

        emotionDetectedService.saveEmotions(savedInducing, user, inducingDTO.listEmotions());

        return savedInducing;
    }

    public InducingResponceDTO getInducingDetails(Long inducingId) {
        Inducing inducing = inducingRepository.findById(inducingId)
                .orElseThrow(() -> new RuntimeException("Indução não encontrada com ID: " + inducingId));
        User user = inducing.getUser();
        List<EmotionDetected> emotionsDetected = emotionDetectedRepository.findByInducing(inducing);


        Map<Long, List<EmotionDetected>> emotionsByVideo = emotionsDetected.stream()
                .collect(Collectors.groupingBy(EmotionDetected::getIdVideo));



        List<VideoEmotionDetailDTO> detailsInducing = new ArrayList<>();
        Map<Long, String> dominantEmotionByVideo = new HashMap<>();

        for (Map.Entry<Long, List<EmotionDetected>> entry : emotionsByVideo.entrySet()) {
            Long videoId = entry.getKey();
            List<EmotionDetected> emotions = entry.getValue();

            Map<String, Long> emotionCounts = emotions.stream()
                    .collect(Collectors.groupingBy(e -> e.getEmocao().name(), Collectors.counting()));

            String dominantEmotionVideo = emotionCounts.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse(null);

            dominantEmotionByVideo.put(videoId, dominantEmotionVideo);

            detailsInducing.add(new VideoEmotionDetailDTO(videoId, dominantEmotionVideo != null ? List.of(dominantEmotionVideo) : List.of()));
        }

        Map<String, Long> overallEmotionCounts = dominantEmotionByVideo.values().stream()
                .filter(emotion -> emotion != null)
                .collect(Collectors.groupingBy(emotion -> emotion, Collectors.counting()));

        String dominantEmotionInducing = overallEmotionCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

        return new InducingResponceDTO(
                user,
                inducing.getDataInicio(),
                inducing.getDataFim(),
                inducing.getEmocaoEscolha(),
                dominantEmotionInducing,
                inducing.getId(),
                detailsInducing
        );
    }
    public List<InducingResponceDTO> getAllInducingDetails() {
        List<Inducing> allInducings = inducingRepository.findAll();
        return allInducings.stream()
                .map(inducing -> getInducingDetails(inducing.getId()))
                .collect(Collectors.toList());
    }

}
