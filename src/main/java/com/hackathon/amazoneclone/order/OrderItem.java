package com.hackathon.amazoneclone.order;

import com.hackathon.amazoneclone.product.Product;
import com.hackathon.amazoneclone.utils.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

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

    @ManyToOne
    private Product product;

    @NotNull
    @Min(value = 1)
    private Integer quantity;

    @NotNull
    @DecimalMin(value = "0.00")
    private BigDecimal subPrice;
}
