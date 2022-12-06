package com.example.firstapplication.examples.leak;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/examples/leak")
@RequiredArgsConstructor
class LeakyController {
    private final LeakyService leakyService;

    @GetMapping("/prepare")
    String prepare() {
        leakyService.prepare();
        return "OK";
    }

    @GetMapping("/do-leak")
    String doLeak() {
        Random random = ThreadLocalRandom.current();
        return leakyService.getValueForKey(random.nextInt());
    }
}
