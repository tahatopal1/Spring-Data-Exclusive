package com.example.springdataexclusive.repository;

import com.example.springdataexclusive.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> { }
