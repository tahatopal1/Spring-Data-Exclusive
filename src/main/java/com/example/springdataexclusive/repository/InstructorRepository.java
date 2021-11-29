package com.example.springdataexclusive.repository;

import com.example.springdataexclusive.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Integer> { }
