package com.honeybadgerworks.io.resumeportal.repository;

import com.honeybadgerworks.io.resumeportal.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
    Optional<User> findByUserId(Integer userId);
}