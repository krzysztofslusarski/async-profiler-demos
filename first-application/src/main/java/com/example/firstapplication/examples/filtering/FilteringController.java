package com.example.firstapplication.examples.filtering;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examples/filtering")
@RequiredArgsConstructor
class FilteringController {
    private final FilteringService filteringService;

    @GetMapping("/")
    String doSomething() {
        filteringService.doSomething();
        return "OK";
    }
}
