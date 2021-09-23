package com.hackathon.amazoneclone.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * @author danyls ngongang
 * @Created 23/09/2021-22:45
 * @Project user-service
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
}
