package com.example.firstapplication.examples.alloc;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examples/alloc")
@RequiredArgsConstructor
class AllocController {
    @GetMapping("/")
    String get() {
        return "OK";
    }
}
