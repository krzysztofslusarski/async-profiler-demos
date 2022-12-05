package com.example.firstapplication.examples.filtering;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class FilteringConfiguration {
    @Bean
    FilteringService filteringService() {
        return new FilteringService();
    }
}