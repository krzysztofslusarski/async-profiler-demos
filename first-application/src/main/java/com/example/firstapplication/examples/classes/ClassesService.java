package com.example.firstapplication.examples.classes;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

@Slf4j
class ClassesService {
    @SneakyThrows
    void doLeak() {
        File jarFile = new File("/Users/pasq/Plusat/IdeaProjects/Robocze/AsyncProfilerDemos/class-leak/target/class-leak-0.0.1-SNAPSHOT.jar");
        try (URLClassLoader loader = new URLClassLoader(new URL[]{jarFile.toURI().toURL()}, null)) {
            Class<?> leakyClass = loader.loadClass("LeakyClass");
            Class<?> notLeakyClass = loader.loadClass("NotLeakyClass");
            leakyClass.getDeclaredMethod("hello").invoke(leakyClass);
            notLeakyClass.getDeclaredMethod("hello").invoke(notLeakyClass);
        }
    }
}
