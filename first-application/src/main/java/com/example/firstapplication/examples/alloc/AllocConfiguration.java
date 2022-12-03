package com.example.firstapplication.examples.alloc;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
class AllocConfiguration {
    @Bean
    CommonsRequestLoggingFilter requestLoggingFilter() {
        CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter() {
            @Override
            protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
                return !request.getRequestURI().contains("alloc");
            }
        };

        loggingFilter.setIncludeClientInfo(true);
        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);
        loggingFilter.setMaxPayloadLength(5 * 1024 * 1024);
        loggingFilter.setIncludeHeaders(true);
        return loggingFilter;
    }
}
