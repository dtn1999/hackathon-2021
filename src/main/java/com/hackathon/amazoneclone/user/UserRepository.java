package com.hackathon.amazoneclone.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author danyls ngongang
 * @Created 10/09/2021-11:32
 * @Project user-service
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findUserByEmail(String userEmail);
}
