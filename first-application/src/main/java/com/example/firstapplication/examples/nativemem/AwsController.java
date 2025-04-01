package com.example.firstapplication.examples.nativemem;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examples/aws")
@RequiredArgsConstructor
class AwsController {
    private final AwsService awsService;

    @GetMapping("/upload")
    String upload() {
        awsService.createNewBuffer();
        return "OK";
    }
}
