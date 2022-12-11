package com.example.jmh;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

public class CpuConsumerBenchmark {
    static final int SIZE = 1024;
    static final int[][] A = new int[SIZE][SIZE];
    static final int[][] B = new int[SIZE][SIZE];

    static {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                A[i][j] = i * j;
                B[i][j] = i / (j + 1);
            }
        }
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    public void slow(Blackhole blackhole) {
        blackhole.consume(matrixMultiplySlow(A, B, SIZE));
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @Warmup(iterations = 1)
    @Measurement(iterations = 1)
    @BenchmarkMode(Mode.AverageTime)
    public void fast(Blackhole blackhole) {
        blackhole.consume(matrixMultiplyFaster(A, B, SIZE));
    }

    public static int[][] matrixMultiplySlow(int[][] a, int[][] b, int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int sum = 0;
                for (int k = 0; k < size; k++) {
                    sum += a[i][k] * b[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    public static int[][] matrixMultiplyFaster(int[][] a, int[][] b, int size) {
        int[][] result = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                int current = a[i][k];
                for (int j = 0; j < size; j++) {
                    result[i][j] += current * b[k][j];
                }
            }
        }
        return result;
    }
}
