package com.example.firstapplication.examples.leak;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

@RequiredArgsConstructor
class LeakyService {
    private final LeakyEntityRepository leakyConfigurationRepository;
    private final JdbcTemplate jdbcTemplate;

    void prepare() {
        for (int i = 0; i < 100; i++) {
            leakyConfigurationRepository.save(new LeakyEntity(i, "value-" + i));
        }
    }

    String getValueForKey(int key) {
        try {
            return jdbcTemplate.queryForObject("select a_value from LEAKY_ENTITY where a_Key = " + key, String.class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
