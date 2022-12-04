package com.example.thirdapplication.examples.context;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class ContextService {
    private static final int LIST_SIZE = 3_000_000;
    private final AtomicInteger counter = new AtomicInteger();
    private volatile int blackhole;

    void doSomething() {
        if (counter.incrementAndGet() % 4 == 0) {
            blackhole = slowPath();
            return;
        }
        blackhole = fastPath();
    }

    private int slowPath() {
        Random random = new Random();
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < LIST_SIZE; i++) {
            integers.add(random.nextInt());
        }
        integers.sort(Integer::compareTo);
        return integers.get(0);
    }

    private int fastPath() {
        Random random = new Random();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < LIST_SIZE; i++) {
            min = Math.min(min, random.nextInt());
        }
        return min;
    }
}
