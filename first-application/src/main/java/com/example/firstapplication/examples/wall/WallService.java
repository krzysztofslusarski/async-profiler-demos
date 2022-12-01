package com.example.firstapplication.examples.wall;

import com.example.firstapplication.CpuConsumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

import static com.example.firstapplication.CommonConfiguration.SECOND_APPLICATION_URL;

@Slf4j
@RequiredArgsConstructor
class WallService {
    static final int CPU_MATH_ITERATIONS = 500_000;

    private final RestTemplate pool20RestTemplate;
    private final RestTemplate pool3RestTemplate;

    void calculateAndExecuteSlow() {
        Random random = ThreadLocalRandom.current();
        CpuConsumer.mathConsumer(random.nextDouble(), CPU_MATH_ITERATIONS);

        invokeWithLogTime(() ->
                pool20RestTemplate.getForObject(SECOND_APPLICATION_URL + "/examples/wall/slow", String.class)
        );
    }

    void calculateAndExecuteFast() {
        Random random = ThreadLocalRandom.current();
        CpuConsumer.mathConsumer(random.nextDouble(), CPU_MATH_ITERATIONS);

        invokeWithLogTime(() ->
                pool3RestTemplate.getForObject(SECOND_APPLICATION_URL + "/examples/wall/fast", String.class)
        );
    }

    private <T> T invokeWithLogTime(Supplier<T> toInvoke) {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        T ret = toInvoke.get();
        stopWatch.stop();

        log.info("External WS invoked in: {}ms", stopWatch.getTotalTimeMillis());
        return ret;
    }
}
