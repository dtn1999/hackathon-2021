package com.hackathon.amazoneclone.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author danyls ngongang
 * @Created 10/09/2021-11:33
 * @Project user-service
 */
@Repository
public interface LoginDetailRepository extends JpaRepository<LoginDetail, UUID> {
    Optional<LoginDetail> findLoginDetailByUser_Email(String email);
    boolean existsLoginDetailByUser_Email(String email);
}
