package com.hackathon.blablacar.userservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author danyls ngongang
 * @Created 12/09/2021-09:31
 * @Project user-service
 */
@Configuration
@EnableJpaRepositories(basePackages = "com.hackathon.blablacar.userservice")
public class AppConfig {
}
