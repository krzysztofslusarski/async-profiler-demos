package com.example.secondapplication.examples.context;

import com.example.common.AsyncProfilerObservationHandler;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@RequiredArgsConstructor
class ContextConfiguration {
    @Bean
    @Profile("context")
    ObservedAspect observedAspect(ObservationRegistry observationRegistry) {
        observationRegistry.observationConfig().observationHandler(new AsyncProfilerObservationHandler());
        return new ObservedAspect(observationRegistry);
    }

    @Bean
    ContextService contextService() {
        return new ContextService();
    }
}
