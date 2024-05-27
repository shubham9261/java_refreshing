package com.learnSpringBoot.demo.rest;

import com.learnSpringBoot.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FunRest {

    private  List<Student> stds=new ArrayList<>();

    @PostConstruct
    public void load(){
        stds.add(new Student("fu","la","a@email.com"));
        stds.add(new Student("fula","la","a@email.com"));
        stds.add(new Student("fulu","la","a@email.com"));
    }

    @GetMapping("/")
    public String sayHello(){
        return "HELLOhjasljlajlaljlajsahsk";
    }

    @GetMapping("/hello")
    public String sayHelloAgain(){
        return "shubham";
    }

    @GetMapping("/student")
    public List<Student> getStudents(){
        return  stds;
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable Integer id){
        try{
            return  stds.get(id);
        }
        catch (Exception ex){
            throw new StudentNotFoundException("Student not found exception"+id);
        }
    }

    //Add an exception handler...


}
