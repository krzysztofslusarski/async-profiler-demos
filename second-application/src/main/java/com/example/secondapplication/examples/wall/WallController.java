package com.example.secondapplication.examples.wall;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examples/wall")
class WallController {
    private final AtomicLong slowCounter = new AtomicLong();

    @GetMapping("/fast")
    String fast() throws InterruptedException {
        Thread.sleep(500);
        return "OK";
    }

    @GetMapping("/slow")
    String slow() throws InterruptedException {
        var counter = slowCounter.incrementAndGet();
        if (counter % 4 == 0) {
            Thread.sleep(1_000);
        } else {
            Thread.sleep(500);
        }
        return "OK";
    }
}
