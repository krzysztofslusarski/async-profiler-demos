package com.example.firstapplication.examples.tts;

import jakarta.annotation.PreDestroy;
import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicBoolean;

class TtsService {
    private static final int LENGTH = 1024 * 1024 * 250;

    private final AtomicBoolean doSafepoints = new AtomicBoolean();

    private volatile Object blackhole;

    private final Thread safepointThread = new Thread(() -> {
        while (!Thread.interrupted()) {
            if (!doSafepoints.get()) {
                synchronized (doSafepoints) {
                    try {
                        doSafepoints.wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            } else {
                for (int i = 0; i < 100; i++) {
                    blackhole = Thread.getAllStackTraces();
                }
            }
        }
    });

    private volatile byte[] firstArray = new byte[LENGTH];
    private volatile byte[] secondArray = new byte[LENGTH];

    void startThread() {
        firstArray = new byte[LENGTH];
        secondArray = new byte[LENGTH];
        safepointThread.start();
    }

    @PreDestroy
    void interruptThread() {
        safepointThread.interrupt();
    }

    @SneakyThrows
    void execute() {
        doSafepoints.set(true);
        synchronized (doSafepoints) {
            doSafepoints.notifyAll();
        }
        Thread.sleep(100);

        System.arraycopy(firstArray, 0, secondArray, 0, LENGTH);

        doSafepoints.set(false);
    }
}
