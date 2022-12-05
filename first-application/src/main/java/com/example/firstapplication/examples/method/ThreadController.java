package com.example.firstapplication.examples.method;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/examples/thread")
@RequiredArgsConstructor
class ThreadController {
    @SneakyThrows
    @GetMapping("/")
    String doInNewThread() {
        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        return threadPool.submit(() -> {
            return "OK";
        }).get();
    }
}
