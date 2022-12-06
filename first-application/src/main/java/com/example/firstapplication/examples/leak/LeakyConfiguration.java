package com.example.firstapplication.examples.leak;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@RequiredArgsConstructor
class LeakyConfiguration {
    private final LeakyEntityRepository leakyEntityRepository;
    private final JdbcTemplate jdbcTemplate;

    @Bean
    LeakyService leakyService() {
        return new LeakyService(leakyEntityRepository, jdbcTemplate);
    }
}
