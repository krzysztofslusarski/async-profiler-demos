package com.example.firstapplication.examples.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
class LockService {
    private final Map<String, String> map = new ConcurrentHashMap<>();

    LockService() {
        String a = "AaAa";
        String b = "BBBB";
        log.info("Hashcode equals: {}", a.hashCode() == b.hashCode());
        map.computeIfAbsent(a, s -> a);
        map.computeIfAbsent(b, s -> b);
    }

    void withLock(String key) {
        map.computeIfAbsent(key, s -> key);
    }

    void withoutLock(String key) {
        if (map.get(key) == null) {
            map.computeIfAbsent(key, s -> key);
        }
    }
}
