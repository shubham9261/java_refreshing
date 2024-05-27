package com.learnSpringBoot.demo.config;


import com.learnSpringBoot.demo.impl.SwimCoach;
import com.learnSpringBoot.demo.interfaces.Coach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean("dummy")
    public Coach SwimCoach(){
        return new SwimCoach();
    }
}
