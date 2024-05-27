package com.learnSpringBoot.demo.dao;

import com.learnSpringBoot.demo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);

    void update(Student student);

//    void delete(Student student);

    void delete(Integer id);

    int deleteAll();

    List<Student>findAll();
    List<Student> findByLastName(String lastName);
}
