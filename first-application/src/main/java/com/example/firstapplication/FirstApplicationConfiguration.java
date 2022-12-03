package com.example.firstapplication;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableJpaRepositories
class FirstApplicationConfiguration {
    @Bean("pool20RestTemplate")
    RestTemplate pool20RestTemplate() {
        return createRestTemplate(20);
    }

    @Bean("pool3RestTemplate")
    RestTemplate pool3RestTemplate() {
        return createRestTemplate(3);
    }

    @Bean("genericRestTemplate")
    RestTemplate genericRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    private static RestTemplate createRestTemplate(int max) {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setDefaultMaxPerRoute(max);
        connectionManager.setMaxTotal(max);

        RequestConfig requestConfig = RequestConfig
                .custom()
                .build();

        HttpClient httpClient = HttpClientBuilder.create()
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(requestConfig).build();

        ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);

        return new RestTemplate(requestFactory);
    }
}
