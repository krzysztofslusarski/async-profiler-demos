package com.example.firstapplication.examples.nativemem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class NativeMemConfiguration {
    @Bean
    NativeMemService nativeMemService() {
        return new NativeMemService();
    }

    @Bean
    AwsService awsService() {
        return new AwsService();
    }

    @Bean
    MallocService mallocService() {
        return new MallocService();
    }
}
