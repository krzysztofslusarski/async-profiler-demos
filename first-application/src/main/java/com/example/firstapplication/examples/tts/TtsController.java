package com.example.firstapplication.examples.tts;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examples/tts")
@RequiredArgsConstructor
class TtsController {
    private final TtsService ttsService;

    @GetMapping("/")
    String doSomething() {
        ttsService.doSomething();
        return "OK";
    }
}
