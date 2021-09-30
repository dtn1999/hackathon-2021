package com.hackathon.amazoneclone.order;

import com.hackathon.amazoneclone.order.dto.OrderDTO;
import com.hackathon.amazoneclone.product.Product;
import com.hackathon.amazoneclone.utils.APIResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @Operation(
            description = "Place an order",
            summary = "This endpoint allow an authenticated user to place an order",
            method = "POST",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody( description = "Order to place" , required = true, content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = OrderDTO.class))),
            security = {
                    @SecurityRequirement( name = "", scopes = {

                    })
            },
            responses = {
                    @ApiResponse(
                            description = "Place an order",
                            responseCode = "201",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = APIResponse.class ))
                    ),
                    @ApiResponse(
                            description = "Bad requests will result to an bad request response status",
                            responseCode = "400",
                            content = @Content( mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema( implementation = APIResponse.class))
                    ),
                    @ApiResponse(
                            description = "If the user is not authenticated or does not have an OWNER role then the request will fail",
                            responseCode = "401",
                            content = @Content( mediaType =  MediaType.APPLICATION_JSON_VALUE, schema = @Schema( implementation = APIResponse.class))
                    )
            }
    )
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity makeOrder(@Valid @NotNull Order order){
        return ResponseEntity.ok( orderService.placeOrder( order ));
    }

    @Operation(
            description = "Return the list of order",
            summary = "Return the list of all the order that the current authenticated user has done",
            method = "GET",
            responses = {
                    @ApiResponse(
                            description = "Get the list Order",
                            responseCode = "200",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(uniqueItems = true, minItems = 0, schema = @Schema(implementation = Order.class)))
                    )
            }
    )
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getAllOrder(){
        return ResponseEntity.ok( orderService.getAllOrders());
    }


    @Operation(
            description = "Return a specific order",
            summary = "Return a particular order for the authenticated user",
            method = "GET",
            responses = {
                    @ApiResponse(
                            description = "Get an Order",
                            responseCode = "200",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Order.class))
                    )
            }
    )
    @GetMapping("/{orderId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getOrderById(@PathVariable UUID orderId){
        return ResponseEntity.ok( orderService.getOrderById(orderId));
    }
}
