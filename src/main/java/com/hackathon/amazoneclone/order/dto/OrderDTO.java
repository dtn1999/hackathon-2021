package com.hackathon.amazoneclone.order.dto;

import com.hackathon.amazoneclone.order.OrderItem;
import com.hackathon.amazoneclone.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author danyls ngongang
 * @Created 25/09/2021-10:17
 * @Project user-service
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class OrderDTO {

    @NotNull
    private Date timestamp;

    @NotNull
    @DecimalMin( value =  "0.00")
    private BigDecimal amount;

    @OneToMany
    private Set<OrderItemDTO> items = new HashSet<>();

    private BigDecimal amountShipping = BigDecimal.ZERO;

}
