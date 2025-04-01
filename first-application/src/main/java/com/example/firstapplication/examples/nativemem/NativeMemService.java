package com.example.firstapplication.examples.nativemem;

import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@Slf4j
class NativeMemService {
    private final List<ByteBuffer> buffers = new ArrayList<>();

    void createNewBuffer(boolean leak) {
        ByteBuffer direct = ByteBuffer.allocateDirect(1024 * 1024);
        if (leak) {
            buffers.add(direct);
        }
    }
}
