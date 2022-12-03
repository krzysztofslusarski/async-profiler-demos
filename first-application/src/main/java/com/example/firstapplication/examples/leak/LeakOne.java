package com.example.firstapplication.examples.leak;

import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
class LeakOne {
    private final Set<String> leak = new HashSet<>();

    void doLeak(String s) {
        leak.add(s);
    }
}
