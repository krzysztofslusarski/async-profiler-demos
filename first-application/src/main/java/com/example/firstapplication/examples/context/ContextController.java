package com.example.firstapplication.examples.context;

import com.example.common.AsyncProfilerUtils;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/examples/context")
@RequiredArgsConstructor
class ContextController {
    private final ContextService contextService;

    @GetMapping("/observe")
    String observe() {
        contextService.observed();
        return "OK";
    }

    @SneakyThrows
    @GetMapping("/start")
    String start() {
        AsyncProfilerUtils.start("/tmp/firstApp.jfr");
        return "OK";
    }

    @SneakyThrows
    @GetMapping("/stop")
    String stop() {
        AsyncProfilerUtils.stop("/tmp/firstApp.jfr");
        return "OK";
    }
}
