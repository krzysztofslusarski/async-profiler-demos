package com.example.firstapplication.examples.wall;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/examples/wall")
@RequiredArgsConstructor
class WallController {
    private final RestTemplate pool20RestTemplate;
    private final RestTemplate pool3RestTemplate;

    @GetMapping("/first")
    String first() {
        pool20RestTemplate.getForObject("http://localhost:8079/examples/wall/slow", String.class);
        return "OK";
    }

    @GetMapping("/second")
    String second() {
        pool3RestTemplate.getForObject("http://localhost:8079/examples/wall/fast", String.class);
        return "OK";
    }
}
