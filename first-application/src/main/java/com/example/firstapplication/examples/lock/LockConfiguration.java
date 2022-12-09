package com.example.firstapplication.examples.lock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LockConfiguration {
    @Bean
    LockService lockService() {
        return new LockService();
    }
}
