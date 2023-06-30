package com.github.kvncont.todospringbootdapr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.dapr.client.DaprClient;
import io.dapr.client.DaprClientBuilder;

@Configuration
public class DaprConfig {

    @Bean
    public DaprClient getClient() {
        return (new DaprClientBuilder()).build();
    }
}
