package com.hackathon.amazoneclone.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 * @author danyls ngongang
 * @Created 23/09/2021-22:42
 * @Project user-service
 */
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Rating {

    @NotNull
    private Integer count;

    @NotNull
    private Float rate;
}
