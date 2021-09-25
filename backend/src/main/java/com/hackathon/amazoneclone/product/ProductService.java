package com.hackathon.amazoneclone.product;

import com.hackathon.amazoneclone.utils.APIResponse;
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

    public APIResponse addAllProducts(@NotNull Set<Product> products){

        return APIResponse.builder()
                .success( true )
                .data(projectRepository.saveAll( products ))
                .error( null )
                .build();

    }

    public APIResponse save(Product product) {
        return APIResponse.builder()
                .success( true )
                .data( projectRepository.save(product))
                .error( null )
                .build();
    }

    public APIResponse getAllProducts() {
        return APIResponse.builder()
                .success( true )
                .data( projectRepository.findAll() )
                .error(null)
                .build();
    }

    public APIResponse getProductById(@NotNull UUID productId){
        return APIResponse.builder()
                .success( true )
                .error( null )
                .data( projectRepository.findById( productId))
                .build();
    }
}
