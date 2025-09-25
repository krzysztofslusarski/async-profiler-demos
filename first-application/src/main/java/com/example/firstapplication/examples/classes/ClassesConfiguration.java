package com.example.firstapplication.examples.classes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ClassesConfiguration {
    @Bean
    ClassesService classesService() {
        return new ClassesService();
    }
}
