package com.example.firstapplication.examples.nativemem;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examples/nativemem")
@RequiredArgsConstructor
class NativeMemController {
    private final NativeMemService nativeMemService;

    @GetMapping("/leak")
    String getWithLeak() {
        nativeMemService.createNewBuffer(true);
        return "OK";
    }

    @GetMapping("/no-leak")
    String getNoLeak() {
        nativeMemService.createNewBuffer(false);
        return "OK";
    }
}
