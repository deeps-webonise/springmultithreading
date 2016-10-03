package com.webonise.springconcurrentmodificationresolved;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Configuration
public class ApplicationConfig {
    @Bean
    public List<String> a() {
        return new CopyOnWriteArrayList<>();
    }

}