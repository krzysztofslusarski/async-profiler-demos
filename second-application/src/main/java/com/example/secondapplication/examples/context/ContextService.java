package com.example.secondapplication.examples.context;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
class ContextService {
    private final AtomicInteger counter = new AtomicInteger();

    void doSomething() {
        if (counter.incrementAndGet() % 3 == 0) {
            slowPath();
            return;
        }

        fastPath();
    }

    @SneakyThrows
    private void fastPath() {
        Thread.sleep(500);
    }

    @SneakyThrows
    private void slowPath() {
        Thread.sleep(2_000);
    }
}
