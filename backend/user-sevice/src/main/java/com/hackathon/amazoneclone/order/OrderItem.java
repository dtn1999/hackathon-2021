package com.hackathon.amazoneclone.order;

import com.hackathon.amazoneclone.product.Product;
import com.hackathon.amazoneclone.utils.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn( name = "order_item_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id" )

    )
    private Set<Product> products = new HashSet<>();

    @NotNull
    @DecimalMin(value = "0.00")
    private BigDecimal subPrice;
}
