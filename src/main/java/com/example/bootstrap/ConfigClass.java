package com.example.bootstrap;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = {"com.example.bootstrap"})

@EntityScan("com.example.bootstrap.entity")
@EnableJpaRepositories("com.example.bootstrap.repository")
public class ConfigClass {
    @Bean
public RestTemplate restTemplate() {
    return new RestTemplate();
}
}
