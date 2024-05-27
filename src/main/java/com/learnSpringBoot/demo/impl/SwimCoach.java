package com.learnSpringBoot.demo.impl;

import com.learnSpringBoot.demo.interfaces.Coach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

//@Lazy
public class SwimCoach implements Coach {

    public SwimCoach(){
        System.out.println("Swim coach is being injected*****");
    }

    @Override
    public String getDailyWorkout() {
        System.out.println("Swim coach is being injected*****");
        return "I am a swim coach";
    }
}
