package com.learnSpringBoot.demo.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExcHandler {



    @ExceptionHandler
    public ResponseEntity<ErrorResp> handleEzxception(StudentNotFoundException e){
        ErrorResp errorResp=new ErrorResp();
        errorResp.setMessage("Invalid rew");
        errorResp.setStatus(HttpStatus.NOT_FOUND.value());
        errorResp.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResp,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResp>handleEzxception(Exception e){
        ErrorResp errorResp=new ErrorResp();
        errorResp.setMessage("Invalid rew");
        errorResp.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResp.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorResp,HttpStatus.BAD_REQUEST);
    }
}
