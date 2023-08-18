package com.zpcao.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class DepartConfig {

    @LoadBalanced //以负载均衡方式访问
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
