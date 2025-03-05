package com.inducingemotion.InducingEmotion.repository;

import com.inducingemotion.InducingEmotion.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);
}
