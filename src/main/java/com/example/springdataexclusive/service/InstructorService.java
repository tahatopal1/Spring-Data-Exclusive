package com.example.springdataexclusive.service;

import com.example.springdataexclusive.model.Course;
import com.example.springdataexclusive.model.Instructor;

import java.util.List;

public interface InstructorService {

    List<Instructor> findAll();

    void save(Instructor instructor);

    Instructor findById(int id);

    void delete(int id);

    void addCourseToInstructor(int id, Course course);

}
