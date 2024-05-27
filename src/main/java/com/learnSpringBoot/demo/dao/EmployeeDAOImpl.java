package com.learnSpringBoot.demo.dao;

import com.learnSpringBoot.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> q=entityManager.createQuery("from employee",Employee.class);
        List<Employee> employees=q.getResultList();
        return employees;
    }

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
       this.entityManager=entityManager;
    }
}
