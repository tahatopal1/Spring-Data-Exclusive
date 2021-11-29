package com.example.springdataexclusive.repository;

import com.example.springdataexclusive.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> { }
