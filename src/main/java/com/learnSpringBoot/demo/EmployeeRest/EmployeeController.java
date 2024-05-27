package com.learnSpringBoot.demo.EmployeeRest;


import com.learnSpringBoot.demo.dao.EmployeeDAO;
import com.learnSpringBoot.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/apiEmp")
public class EmployeeController {

    private EmployeeDAO employeeDAO;

    @Autowired // not required since this is the only constructor over here..
    public EmployeeController(EmployeeDAO employeeDAO){
        this.employeeDAO=employeeDAO;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeDAO.findAll();
    }
}
