package com.example.firstapplication.examples.classes;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/examples/classes")
@RequiredArgsConstructor
class ClassesController {
    private final ClassesService classesService;

    @GetMapping("/")
    String doLeak() {
        classesService.doLeak();
        return "OK";
    }
}
