package com.hackathon.blablacar.userservice.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * @author danyls ngongang
 * @Created 10/09/2021-11:35
 * @Project user-service
 */
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {

    @Id
    @GeneratedValue( generator = "uuid")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "user_id", unique = true, nullable = false, updatable = false)
    private UUID id;
}
