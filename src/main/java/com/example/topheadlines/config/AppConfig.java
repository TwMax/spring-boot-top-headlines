package com.example.topheadlines.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    //defining a RestTemplate Bean to make it available to the application context
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
