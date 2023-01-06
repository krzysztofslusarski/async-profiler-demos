package com.example.firstapplication.examples.os.quest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class QuestConfiguration {
    @Bean
    QuectCpuClassesService quectCpuClassesService() {
        return new QuectCpuClassesService();
    }

    @Bean
    QuectCpuInterfaceService quectCpuInterfaceService() {
        return new QuectCpuInterfaceService();
    }
}
