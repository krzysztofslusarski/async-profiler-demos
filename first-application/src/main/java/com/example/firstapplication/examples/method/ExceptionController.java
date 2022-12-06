package com.example.firstapplication.examples.method;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/examples/exc")
@RequiredArgsConstructor
class ExceptionController {
    @GetMapping("/")
    String flowControl() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        try {
            if (!random.nextBoolean()) {
                throw new IllegalArgumentException("Random returned false");
            }
        } catch (IllegalArgumentException e) {
            return "EXC";
        }

        return "OK";
    }

}
