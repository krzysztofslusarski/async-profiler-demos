package com.example.firstapplication.examples.cpu;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/examples/cpu")
@RequiredArgsConstructor
class CpuController {
    private final CpuService cpuService;
    private volatile UUID preparedUuid;

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
}
