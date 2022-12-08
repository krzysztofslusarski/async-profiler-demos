package com.example.firstapplication.examples.tts;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class TtsConfiguration {
    @Bean
    TtsService ttsService() {
        return new TtsService();
    }
}
