package com.example.thirdapplication.examples.context;

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
    private final ContextService contextService;

    @GetMapping("/do-something")
    String doSomething() throws InterruptedException {
        contextService.doSomething();
        return "OK";
    }

    @SneakyThrows
    @GetMapping("/start")
    String start() {
        AsyncProfilerUtils.start("/tmp/thirdApp.jfr");
        return "OK";
    }

    @SneakyThrows
    @GetMapping("/stop")
    String stop() {
        AsyncProfilerUtils.stop("/tmp/thirdApp.jfr");
        return "OK";
    }
}
