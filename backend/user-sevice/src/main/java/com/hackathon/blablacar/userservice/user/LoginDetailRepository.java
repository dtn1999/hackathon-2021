package com.hackathon.blablacar.userservice.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author danyls ngongang
 * @Created 10/09/2021-11:33
 * @Project user-service
 */
@Repository
public interface LoginDetailRepository extends JpaRepository<LoginDetail, UUID> {
}
