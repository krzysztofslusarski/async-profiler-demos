package com.example.firstapplication;

import ch.qos.logback.access.tomcat.LogbackValve;
import org.apache.catalina.filters.RemoteIpFilter;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableJpaRepositories
@ServletComponentScan
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

    @Bean
    RemoteIpFilter remoteIpFilter() {
        // Try it with nameserver 72.66.115.13
        RemoteIpFilter remoteIpFilter = new RemoteIpFilter();
        remoteIpFilter.setChangeLocalName(true);
        return remoteIpFilter;
    }

    @Bean
    TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addContextValves(new LogbackValve());
        return tomcat;
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
