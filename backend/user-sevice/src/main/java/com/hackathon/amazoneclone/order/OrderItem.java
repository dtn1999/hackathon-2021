package com.hackathon.amazoneclone.order;

import com.hackathon.amazoneclone.utils.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * @author danyls ngongang
 * @Created 24/09/2021-19:40
 * @Project user-service
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class OrderItem extends BaseEntity {

}
