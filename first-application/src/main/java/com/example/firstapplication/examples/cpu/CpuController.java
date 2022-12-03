package com.example.firstapplication.examples.cpu;

import com.example.firstapplication.CpuConsumer;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examples/cpu")
@RequiredArgsConstructor
class CpuController {
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

    private final CpuService cpuService;
    private volatile UUID preparedUuid;
    private volatile Object blackhole;

    @GetMapping("/prepare")
    String prepare() {
        preparedUuid = cpuService.prepare();
        return "OK";
    }

    @GetMapping("/inverse")
    String inverse() {
        cpuService.inverse(preparedUuid);
        return "OK";
    }

    @GetMapping("/matrix-slow")
    String matrixSlow() {
        blackhole = CpuConsumer.matrixMultiplySlow(A, B, SIZE);
        return "OK";
    }

    @GetMapping("/matrix-fast")
    String matrixFast() {
        blackhole = CpuConsumer.matrixMultiplyFaster(A, B, SIZE);
        return "OK";
    }
}
