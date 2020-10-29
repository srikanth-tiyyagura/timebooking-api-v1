package com.honeybadgerworks.io.resumeportal.repository;

import com.honeybadgerworks.io.resumeportal.domain.User;
import com.honeybadgerworks.io.resumeportal.domain.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
    Optional<UserProfile> findByUserName(String userName);
}
