package com.example.firstapplication;

public abstract class CpuConsumer {
    public static double mathConsumer(double start, int iterations) {
        double result = start;
        for (int i = 0; i < iterations; i++) {
            result = Math.exp(Math.sin(result));
        }
        return result;
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
