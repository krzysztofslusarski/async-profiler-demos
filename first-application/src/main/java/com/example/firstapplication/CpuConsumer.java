package com.example.firstapplication;

public abstract class CpuConsumer {
    public static double mathConsumer(double start, int iterations) {
        double result = start;
        for (int i = 0; i < iterations; i++) {
            result = Math.exp(Math.sin(result));
        }
        return result;
    }
}
