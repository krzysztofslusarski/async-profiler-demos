package com.example.firstapplication.examples.cpu;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
class CpuConfiguration {
    private final SampleEntityRepository sampleEntityRepository;
    private final SampleConfigurationRepository sampleConfigurationRepository;

    @Bean
    CpuService cpuService() {
        return new CpuService(sampleEntityRepository, sampleConfigurationRepository);
    }
}
