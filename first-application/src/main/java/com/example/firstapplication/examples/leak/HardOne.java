package com.example.firstapplication.examples.leak;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/examples/leak")
class HardOne {
    private final LeakOne leakOne;

    @GetMapping
    void doIt() {
        String newOne = RandomStringUtils.randomAlphabetic(10000);
        leakOne.doLeak(newOne);
        LeakTwo.doLeak(newOne);
    }
}
