package com.learnSpringBoot.demo.dao;

import com.learnSpringBoot.demo.entity.Employee;

import java.util.List;



public interface EmployeeDAO {
    List<Employee> findAll();
}
