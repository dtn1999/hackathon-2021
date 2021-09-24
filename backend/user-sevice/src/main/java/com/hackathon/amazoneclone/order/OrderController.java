package com.hackathon.amazoneclone.order;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

/**
 * @author danyls ngongang
 * @Created 24/09/2021-19:54
 * @Project user-service
 */
@RestController
@RequestMapping("api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity makeOrder(@Valid @NotNull Order order){
        return ResponseEntity.ok( orderService.placeOrder( order ));
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getAllOrder(){
        return ResponseEntity.ok( orderService.getAllOrders());
    }


    @GetMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getOrderById(@PathVariable UUID orderId){
        return ResponseEntity.ok( orderService.getOrderById(orderId));
    }
}
