package com.hackathon.amazoneclone.config;

import com.google.maps.GeoApiContext;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author danyls ngongang
 * @Created 12/09/2021-09:31
 * @Project user-service
 */
@Configuration
@PropertySource("classpath:application-secret.properties")
@EnableJpaRepositories(basePackages = "com.hackathon.amazoneclone")
public class AppConfig {

    @Bean
    public GeoApiContext geoApiContext(){
        return  new GeoApiContext.Builder()
                .apiKey("AIzaSyDxToXPgPGG8_1NP3BjgxMM6NFdEoqKiGE")
                .build();
    }

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Amazon clone API")
                        .version( "v0.1" )
                        .description( "Amazon clone is a clone API ")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
