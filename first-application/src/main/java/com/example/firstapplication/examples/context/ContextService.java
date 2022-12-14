package com.example.firstapplication.examples.context;

import static com.example.firstapplication.CommonConfiguration.SECOND_APPLICATION_URL;
import static com.example.firstapplication.CommonConfiguration.THIRD_APPLICATION_URL;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
class ContextService {
    private final RestTemplate genericRestTemplate;

    @SneakyThrows
    void observed() {
        Thread.sleep(500);
        genericRestTemplate.getForObject(SECOND_APPLICATION_URL + "/examples/context/do-something", String.class);
        Thread.sleep(500);
        genericRestTemplate.getForObject(THIRD_APPLICATION_URL + "/examples/context/do-something", String.class);
    }
}
