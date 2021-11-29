package com.example.springdataexclusive.service;

import com.example.springdataexclusive.model.Course;
import com.example.springdataexclusive.model.Review;
import com.example.springdataexclusive.model.Student;
import com.example.springdataexclusive.repository.CourseRepository;
import com.example.springdataexclusive.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;
    private StudentRepository studentRepository;

    public CourseServiceImpl(CourseRepository courseRepository, StudentRepository studentRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional
    public void delete(int id) {
        courseRepository.deleteById(id);
    }

    @Override
    @Transactional
    public String addReviewToCourse(int id, Review review) {
        Course course = courseRepository.getById(id);
        course.getReviews().add(review);
        courseRepository.save(course);
        return "Comment received: " + review.getComment();
    }

    @Override
    public String addStudentToCourse(int studentId, int courseId) {
        Student student = studentRepository.getById(studentId);
        Course course = courseRepository.getById(courseId);
        course.getStudents().add(student); // Bad usage, i'm not going serious :)
        courseRepository.save(course);
        return "Course saved!";
    }
}
