package com.capstone.movieapp.config;

/*
 * create a class AppConfig to configure the bean for resttemplate
 * 
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * This class represents the configuration for the movieapp application.
 * It provides a bean definition for the RestTemplate.
 */
@Configuration
public class AppConfig {
    /**
        * Creates and returns a new instance of RestTemplate.
        *
        * @return the RestTemplate instance
        */
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
