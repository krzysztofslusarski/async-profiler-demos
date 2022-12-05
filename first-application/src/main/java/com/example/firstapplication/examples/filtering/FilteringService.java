package com.example.firstapplication.examples.filtering;

import com.example.firstapplication.CpuConsumer;

import java.util.concurrent.atomic.AtomicInteger;

class FilteringService {
    private static final int SIZE = 1024;
    private static final int[][] A = new int[SIZE][SIZE];
    private static final int[][] B = new int[SIZE][SIZE];

    private final AtomicInteger counter = new AtomicInteger();
    private volatile Object blackhole;

    static {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                A[i][j] = i * j;
                B[i][j] = i / (j + 1);
            }
        }
    }

    void doSomething() {
        if (counter.incrementAndGet() % 4 == 0) {
            slowPath();
            return;
        }
        fastPath();
    }

    private void slowPath() {
        blackhole = CpuConsumer.matrixMultiplySlow(A, B, SIZE);
    }

    private void fastPath() {
        blackhole = CpuConsumer.matrixMultiplyFaster(A, B, SIZE);
    }
}
