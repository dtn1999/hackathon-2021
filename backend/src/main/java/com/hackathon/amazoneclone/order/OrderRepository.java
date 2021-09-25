package com.hackathon.amazoneclone.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

/**
 * @author danyls ngongang
 * @Created 24/09/2021-19:41
 * @Project user-service
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    Set<Order> findAllByCustomer_Email(String userEmail);
}
