package com.example.firstapplication.examples.nativemem;

import lombok.SneakyThrows;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class MallocService {
    @SneakyThrows
    void allocateInLoop(int loopSize, int threadCount) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            threads.add(new Thread(() -> {
                Random random = new Random();
                for (int j = 0; j < loopSize; j++) {
                    ByteBuffer.allocateDirect(random.nextInt(1024 * 1024));
                }
            }));
        }

        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
    }
}
