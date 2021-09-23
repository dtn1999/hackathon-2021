package com.hackathon.amazoneclone.product;

import com.hackathon.amazoneclone.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

/**
 * @author danyls ngongang
 * @Created 23/09/2021-22:45
 * @Project user-service
 */
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository projectRepository;

    public ApiResponse addAllProducts(@NotNull Set<Product> products){

        return ApiResponse.builder()
                .success( true )
                .data(projectRepository.saveAll( products ))
                .error( null )
                .build();

    }

    public ApiResponse save(Product product) {
        return ApiResponse.builder()
                .success( true )
                .data( projectRepository.save(product))
                .error( null )
                .build();
    }

    public ApiResponse getAllProducts() {
        return ApiResponse.builder()
                .success( true )
                .data( projectRepository.findAll() )
                .error(null)
                .build();
    }

    public ApiResponse getProductById(@NotNull UUID productId){
        return ApiResponse.builder()
                .success( true )
                .error( null )
                .data( projectRepository.findById( productId))
                .build();
    }
}
