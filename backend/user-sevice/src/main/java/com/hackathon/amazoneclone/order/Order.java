package com.hackathon.amazoneclone.order;

import com.hackathon.amazoneclone.user.User;
import com.hackathon.amazoneclone.utils.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * @author danyls ngongang
 * @Created 24/09/2021-19:39
 * @Project user-service
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class Order extends BaseEntity {
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;

    @NotNull
    @DecimalMin( value =  "0.00")
    private BigDecimal amount;

    @OneToMany
    private Set<OrderItem> items = new HashSet<>();

    private BigDecimal amountShipping;


    @ManyToOne
    @NotNull
    private User customer;
}
