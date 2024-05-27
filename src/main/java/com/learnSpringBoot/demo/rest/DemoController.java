package com.learnSpringBoot.demo.rest;

import com.learnSpringBoot.demo.interfaces.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    //CONSTRUCTION INJECTION

    @Autowired
    public DemoController (@Qualifier("cricketCoach") Coach coach){
        myCoach=coach;
    }

    @Autowired
    public void setMyCoach(@Qualifier("hockeyCoach") Coach coach,@Qualifier("hockeyCoach") Coach Ancoach){
        myCoach=coach;

//        if(coach==Ancoach)
//            System.out.println("+++BOTHHHHHH EQUAL");
//        else
//            System.out.println("+++BOTHHHHHH UNEQUAL");

    }

    @Autowired
    public void setSwimCoach(@Qualifier("dummy") Coach c){
        System.out.println("******* I am not coming here******");
    }
    @GetMapping("/getCoach")
    public String getWorkout(){
        return myCoach.getDailyWorkout();
    }

}
