package com.hackathon.amazoneclone.order;

import com.hackathon.amazoneclone.product.Product;
import com.hackathon.amazoneclone.product.ProductRepository;
import com.hackathon.amazoneclone.security.SecurityUtils;
import com.hackathon.amazoneclone.user.User;
import com.hackathon.amazoneclone.user.UserRole;
import com.hackathon.amazoneclone.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.NotNull;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * @author danyls ngongang
 * @Created 24/09/2021-19:42
 * @Project user-service
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;


    public ApiResponse placeOrder(@NotNull Order order){
        // validate the given order ( control if product still in stock )
        try {
            validateOrder(order);

            order.getItems().addAll(
                    orderItemRepository.saveAll(order.getItems())
            );
            orderRepository.save( order );
            return ApiResponse.builder()
                    .success( true)
                    .data( true )
                    .error( null )
                    .build();
        }catch (Exception exception){

            log.error(exception.getMessage());
            return ApiResponse.builder()
                    .success( true)
                    .data( false )
                    .error( exception.getMessage() )
                    .build();
        }
    }

    public  ApiResponse getAllOrders(){
        User principal = SecurityUtils.getUserFromSecurityContext();
        return  ApiResponse.builder()
                .success( true )
                .data( orderRepository.findAllByCustomer_Email(principal.getEmail()))
                .build();
    }

    public ApiResponse getOrderById(UUID orderId) {
        User principal = SecurityUtils.getUserFromSecurityContext();
        Set<Order> orders = orderRepository.findAllByCustomer_Email(principal.getEmail());
        Optional<Order> or = orders.stream().filter(order -> order.getId().equals(orderId)).findFirst();
        return  ApiResponse.builder()
                .success( true )
                .data( or.orElseThrow( () -> new NoSuchElementException(String.format("No Order found with the Id %s", orderId))))
                .error( null)
                .build();
    }

    private boolean validateOrder(@NotNull Order order){
        return false;
    }
}
