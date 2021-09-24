package com.hackathon.amazoneclone.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity saveAllProducts(@Valid @RequestBody Set<Product> products){
        return ResponseEntity.ok( productService.addAllProducts( products ));
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getAllProducts(){
        return ResponseEntity.ok( productService.getAllProducts());
    }

    @GetMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getAllProductById(@NotNull @PathVariable  UUID productId){
        return ResponseEntity.ok( productService.getProductById(productId));
    }
}
