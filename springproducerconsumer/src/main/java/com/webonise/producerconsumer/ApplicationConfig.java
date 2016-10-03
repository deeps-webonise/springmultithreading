package com.webonise.producerconsumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ApplicationConfig {
    @Bean
    @Scope("prototype")
    public List<Integer> arrayList() {
        return new ArrayList<>();

    }
}
