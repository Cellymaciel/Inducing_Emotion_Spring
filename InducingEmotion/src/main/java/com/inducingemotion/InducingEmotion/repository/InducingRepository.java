package com.inducingemotion.InducingEmotion.repository;

import com.inducingemotion.InducingEmotion.entitys.Inducing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InducingRepository extends JpaRepository<Inducing, Long> {
    Inducing findInducingById(Long id);
}
