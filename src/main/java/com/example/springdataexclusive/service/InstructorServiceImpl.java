package com.example.springdataexclusive.service;

import com.example.springdataexclusive.model.Course;
import com.example.springdataexclusive.model.Instructor;
import com.example.springdataexclusive.repository.CourseRepository;
import com.example.springdataexclusive.repository.InstructorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    private InstructorRepository instructorRepository;
    private CourseRepository courseRepository;

    public InstructorServiceImpl(InstructorRepository instructorRepository, CourseRepository courseRepository) {
        this.instructorRepository = instructorRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        instructorRepository.save(instructor);
    }

    @Override
    public Instructor findById(int id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Instructor not found. Id: " + id));
    }

    @Override
    @Transactional
    public void delete(int id) {
        this.findById(id);
        instructorRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void addCourseToInstructor(int id, Course course) {
        Instructor instructor = instructorRepository.getById(id);
        instructor.getCourses().add(course);
        course.setInstructor(instructor);
        instructorRepository.save(instructor);
    }

    @Override
    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }
}
