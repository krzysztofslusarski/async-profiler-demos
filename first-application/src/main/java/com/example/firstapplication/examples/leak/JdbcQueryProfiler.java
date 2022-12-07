package com.example.firstapplication.examples.leak;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StopWatch;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

@RequiredArgsConstructor
class JdbcQueryProfiler {
    private final Map<String, ProfilingData> profilingResults = new ConcurrentHashMap<>();

    <T> T runWithProfiler(String queryStr, Supplier<T> query) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        T ret = query.get();
        stopWatch.stop();
        profilingResults.computeIfAbsent(queryStr, ProfilingData::new).nextInvocation(stopWatch.getTotalTimeMillis());
        return ret;
    }

    @RequiredArgsConstructor
    static class ProfilingData {
        private final Object MUX = new Object();
        @Getter
        private final String query;
        private long fullTime;
        private int invocationCount;

        void nextInvocation(long time) {
            synchronized (MUX) {
                invocationCount++;
                fullTime += time;
            }
        }

        BigDecimal avg() {
            synchronized (MUX) {
                return new BigDecimal(fullTime).divide(new BigDecimal(invocationCount), 2, RoundingMode.HALF_EVEN);
            }
        }
    }
}
