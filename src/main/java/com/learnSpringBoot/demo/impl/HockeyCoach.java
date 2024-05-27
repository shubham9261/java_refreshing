package com.learnSpringBoot.demo.impl;

import com.learnSpringBoot.demo.interfaces.Coach;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Lazy
public class HockeyCoach implements Coach {

    public HockeyCoach(){
        System.out.println("I am Hockkey coach***************");
    }
    @Override
    public String getDailyWorkout() {
        return "I am a HOCKEY coach";
    }
}


