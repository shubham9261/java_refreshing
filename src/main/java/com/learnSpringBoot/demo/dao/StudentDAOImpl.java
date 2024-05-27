package com.learnSpringBoot.demo.dao;

import com.learnSpringBoot.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO{
    private EntityManager entityManager;

    @Autowired //Autowired annotationn is optional since we only have one con
    public StudentDAOImpl(EntityManager en){
        this.entityManager=en;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);

    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student st=findById(id);
//        Integer n=entityManager.createQuery("Delete from Student").executeUpdate();
        entityManager.remove(st);
        System.out.println("no of rows deleted: "+ st.toString());
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager.createQuery("Delete from Student").executeUpdate();
//        return 0;
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student>q=entityManager.createQuery("FROM Student order by lastName",Student.class);
        return q.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student>q=entityManager.createQuery("FROM Student where lastName=:data",Student.class);
        q.setParameter("data",lastName);
        return q.getResultList();
    }
}
