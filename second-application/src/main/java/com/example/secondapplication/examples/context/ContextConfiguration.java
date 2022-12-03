package com.example.secondapplication.examples.context;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.descriptor.web.ContextService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
class ContextConfiguration {
    @Bean
    ObservedAspect observedAspect(ObservationRegistry observationRegistry) {
        observationRegistry.observationConfig().observationHandler(new AsyncProfilerObservationHandler());
        return new ObservedAspect(observationRegistry);
    }

    @Bean
    ContextService contextService() {
        return new ContextService();
    }
}
