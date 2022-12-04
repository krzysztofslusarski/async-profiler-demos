package com.example.firstapplication.examples.context;

import com.example.common.AsyncProfilerObservationHandler;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RequiredArgsConstructor
class ContextConfiguration {
    private final RestTemplate genericRestTemplate;

    @Bean
    ObservedAspect observedAspect(ObservationRegistry observationRegistry) {
        observationRegistry.observationConfig().observationHandler(new AsyncProfilerObservationHandler());
        return new ObservedAspect(observationRegistry);
    }

    @Bean
    ContextService contextService() {
        return new ContextService(genericRestTemplate);
    }
}
