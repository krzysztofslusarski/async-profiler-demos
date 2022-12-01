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
    private final WallService wallService;

    @GetMapping("/first")
    String first() {
        wallService.calculateAndExecuteSlow();
        return "OK";
    }

    @GetMapping("/second")
    String second() {
        wallService.calculateAndExecuteFast();
        return "OK";
    }
}
