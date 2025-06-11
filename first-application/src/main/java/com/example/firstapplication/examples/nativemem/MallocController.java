package com.example.firstapplication.examples.nativemem;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examples/malloc")
@RequiredArgsConstructor
class MallocController {
    private final MallocService mallocService;

    @GetMapping("/large")
    String large() {
        mallocService.allocateInLoop(10_000, 60);
        return "OK";
    }

    @GetMapping("/small")
    String small() {
        mallocService.allocateInLoop(10, 1);
        return "OK";
    }
}
