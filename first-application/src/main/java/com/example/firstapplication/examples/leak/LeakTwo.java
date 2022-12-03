package com.example.firstapplication.examples.leak;

import java.util.HashSet;
import java.util.Set;

class LeakTwo {
    private static final Set<String> leak = new HashSet<>();

    static void doLeak(String s) {
        leak.add(s);
    }
}