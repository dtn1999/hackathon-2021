package com.hackathon.amazoneclone.bootstrap;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackathon.amazoneclone.product.Product;
import com.hackathon.amazoneclone.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

/**
 * @author danyls ngongang
 * @Created 23/09/2021-22:55
 * @Project user-service
 */
@Service
@RequiredArgsConstructor
public class Bootstrapping implements CommandLineRunner {

    private final ProductService productService;

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<Set<Product>> typeReference = new TypeReference<Set<Product>>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/static/products.json");
        try {
            Set<Product> products = mapper.readValue(inputStream,typeReference);
           products.forEach( product -> {
               productService.save(product);
           });
            System.out.println("############################################################### All Products where correctly saved ###################################################################");
        } catch (IOException e){
            System.out.println("Unable to save Products: " + e.getMessage());
        }
    }
}
