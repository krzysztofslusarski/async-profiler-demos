package com.example.common;

import api.one.profiler.AsyncProfiler;
import java.io.IOException;

public abstract class AsyncProfilerUtils {
    private static volatile AsyncProfiler asyncProfiler;
    private static final Object MUX = new Object();

    public static AsyncProfiler load() {
        if (asyncProfiler == null) {
            synchronized (MUX) {
                if (asyncProfiler == null) {
                    asyncProfiler = AsyncProfiler.getInstance("/tmp/libasyncProfiler.so");
                }
            }
        }
        return asyncProfiler;
    }

    public static void start(String filename) throws IOException {
        load().execute("start,jfr,event=wall,file=" + filename);
    }

    public static void stop(String filename) throws IOException {
        load().execute("stop,jfr,event=wall,file=" + filename);
    }
}
