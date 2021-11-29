package com.example.springdataexclusive.service;

import com.example.springdataexclusive.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    void save(Student student);

    Student findById(int id);

    void delete(int id);

}
