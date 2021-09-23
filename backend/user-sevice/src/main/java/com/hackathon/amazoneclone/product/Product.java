package com.hackathon.amazoneclone.product;

import com.hackathon.amazoneclone.utils.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * @author danyls ngongang
 * @Created 23/09/2021-21:21
 * @Project user-service
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class Product extends BaseEntity {
    @NotNull
    private String title;

    @NotNull
    private String category;

    @NotNull
    @Size(max = 1000)
    private String description;

    @NotNull
    private BigDecimal price;

    @NotNull
    private String image;

    @Embedded
    private Rating rating;
}
