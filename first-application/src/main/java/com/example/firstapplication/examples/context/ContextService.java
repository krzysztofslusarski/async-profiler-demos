package com.example.firstapplication.examples.context;

import static com.example.firstapplication.CommonConfiguration.SECOND_APPLICATION_URL;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
class ContextService {
    private final RestTemplate genericRestTemplate;

    void observed() {
        log.info("invoking");
        genericRestTemplate.getForObject(SECOND_APPLICATION_URL + "/examples/context/", String.class);
        log.info("invoked");
    }
}
