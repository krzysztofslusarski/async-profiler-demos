package com.example.firstapplication.examples.wall;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
class WallConfiguration {
    private final RestTemplate pool20RestTemplate;
    private final RestTemplate pool3RestTemplate;

    @Bean
    WallService wallService() {
        return new WallService(pool20RestTemplate, pool3RestTemplate);
    }
}
