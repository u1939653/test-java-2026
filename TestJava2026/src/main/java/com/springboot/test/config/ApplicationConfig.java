package com.springboot.test.config;

import com.springboot.test.domain.service.PricesDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public PricesDomainService pricesDomainService() {
        return new PricesDomainService();
    }
}