package com.example.firstapplication.examples.lock;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examples/lock")
@RequiredArgsConstructor
class LockController {
    private final LockService lockService;

    @GetMapping("/with-lock")
    String with() {
        lockService.withLock("BBBB");
        return "OK";
    }

    @GetMapping("/without-lock")
    String without() {
        lockService.withoutLock("BBBB");
        return "OK";
    }
}
