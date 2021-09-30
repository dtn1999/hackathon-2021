package com.hackathon.amazoneclone.product;

import com.hackathon.amazoneclone.utils.APIResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

/**
 * @author danyls ngongang
 * @Created 23/09/2021-22:48
 * @Project user-service
 */
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @Operation(
            description = "Create a list of products ",
            summary = "This endpoint allow to a Shop owner to add several products to the database at once. User with role= CUSTOMER are not allow to make this call",
            method = "POST",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody( description = "List of products to create" , required = true, content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Product[].class))),
            security = {
                @SecurityRequirement( name = "", scopes = {

                })
            },
            responses = {
                    @ApiResponse(
                            description = "Add a list of product to the database",
                            responseCode = "201",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = APIResponse.class, defaultValue = "[]"))
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
    public ResponseEntity saveAllProducts(@Valid @RequestBody Set<Product> products){
        return ResponseEntity.ok( productService.addAllProducts( products ));
    }

    @Operation(
            description = "Get the list of all available products ",
            summary = "This endpoint allow to all user  to get the list of all  products",
            method = "GET",
            responses = {
                    @ApiResponse(
                            description = "Get the list of all the avalaible products",
                            responseCode = "200",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(uniqueItems = true, minItems = 0, schema = @Schema(implementation = Product.class)))
                    )
            }
    )
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getAllProducts(){
        return ResponseEntity.ok( productService.getAllProducts());
    }

    @Operation(
            description = "Get A product by ID",
            summary = "This endpoint allow to all user  to get a product by ID",
            method = "GET",
            parameters = {
                @Parameter(description = "ID of the product to get ", name = "productId" , required = true , schema = @Schema(implementation = UUID.class))
            },
            responses = {
                    @ApiResponse(
                            description = "Get the list of all the avalaible products",
                            responseCode = "200",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Product.class, defaultValue = "[]"))
                    )
            }
    )
    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getAllProductById(@NotNull @PathVariable  UUID productId){
        return ResponseEntity.ok( productService.getProductById(productId));
    }
}
