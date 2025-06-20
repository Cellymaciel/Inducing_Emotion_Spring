package com.inducingemotion.InducingEmotion.repository;

import com.inducingemotion.InducingEmotion.entitys.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, String> {
  User findByEmail(String email);

  boolean existsByEmail(String email);

  Optional<User> findById(String email);
}
