package com.example.secondapplication.examples.context;

import com.example.common.AsyncProfilerUtils;
import io.micrometer.observation.annotation.Observed;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Observed
@RestController
@RequestMapping("/examples/context")
@RequiredArgsConstructor
class ContextController {
    @GetMapping("/do-something")
    String get() throws InterruptedException {
        Thread.sleep(1000);
        return "OK";
    }

    @SneakyThrows
    @GetMapping("/start")
    String start() {
        AsyncProfilerUtils.start("/tmp/secondApp.jfr");
        return "OK";
    }

    @SneakyThrows
    @GetMapping("/stop")
    String stop() {
        AsyncProfilerUtils.stop("/tmp/secondApp.jfr");
        return "OK";
    }
}
