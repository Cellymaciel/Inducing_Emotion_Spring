package com.inducingemotion.InducingEmotion.repository;

import com.inducingemotion.InducingEmotion.entitys.Inducing;
import com.inducingemotion.InducingEmotion.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InducingRepository extends JpaRepository<Inducing, Long> {
    Inducing findInducingById(Long id);

    List<Inducing> findByUser_Email(String email);

    List<Inducing> findTopByUserOrderByDataInicioDesc(User user);
}
