package com.learnSpringBoot.demo.impl;

import com.learnSpringBoot.demo.interfaces.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("I am Cricet coach***************");
    }

    @Override
    public String getDailyWorkout() {
        return "I am a cricket coach";
    }


    @PostConstruct
    public void cr(){
        System.out.println("Object is created for cricket coach****************");
    }

    @PreDestroy
    public void dest(){
        System.out.println("Object is destrpyed for cricket coach****************");
    }
}
