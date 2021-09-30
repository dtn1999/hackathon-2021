package com.hackathon.amazoneclone.order.dto;

import com.hackathon.amazoneclone.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author danyls ngongang
 * @Created 25/09/2021-10:18
 * @Project user-service
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class OrderItemDTO {
    @NotNull
    private UUID productId;

    @NotNull
    @Min(value = 1)
    private Integer quantity;

    @NotNull
    @DecimalMin(value = "0.00")
    private BigDecimal subPrice;
}
